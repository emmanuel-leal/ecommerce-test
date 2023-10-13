#!/bin/bash

container=$1
substring=$2
timeout=${3:-30}
wait=${4:-500}

interval=$(echo "scale=2; $wait/1000"|bc -l);

printHelp() {
	echo
	echo "HELP for 'wait-for-container.sh'"
	echo "usage:"
	echo "./wait-for-container.sh <container name> <substring to find> <seconds to wait> <milliseconds between retries>"
	echo "The final two options, wait & retry, are optional and will default to 30 & 500 respectively."
	echo
	exit 0
}

if [ -z "$container" ] || [ "$container" == "help" ] || [ -z "$substring" ]
then
	printHelp
fi

echo "waiting $timeout seconds for container: $container with substring: $substring"

checkForSubstring() {
	printf "."
	dockerlogfile="$(docker logs $container >& wait_for_docker_logs.txt)"
	dockerlog="$(<wait_for_docker_logs.txt)"
	removelog="$(rm -f wait_for_docker_logs.txt)"

	if [[ "$dockerlog" == *"$substring"* ]]
	then
		found="true"
	fi
}

start=$SECONDS
run="true"
found="false"

while [ "$run" = "true" ]
do
	checkForSubstring

	if [[ "$found" == "true" ]]
	then
		run="false"
		echo
		echo "$container is ready after $SECONDS seconds."
	fi

	sleep $interval

	if (( $SECONDS > $timeout))
	then
		run="false"
		echo
		echo "ERROR:  Timeout occurred after waiting $timeout seconds for $container."
	fi
done