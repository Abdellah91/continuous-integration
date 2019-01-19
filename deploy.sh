#!/bin/bash

REGION=eu-west-3
CLUSTER=rater-cluster

FAMILY=$(sed -n 's/.*"family": "\(.*\)",/\1/p' rater-task-definition.json)
echo "family is $FAMILY"
NAME=$(sed -n 's/.*"name": "\(.*\)",/\1/p' rater-task-definition.json)
SERVICE_NAME=${NAME}-service
echo "service name is $SERVICE_NAME"


aws --profile abdel ecs register-task-definition --cli-input-json file://rater-task-definition.json
SERVICES=$(aws --profile abdel ecs describe-services --services ${SERVICE_NAME} --cluster ${CLUSTER} | jq .failures[])
echo "SERVICES is $SERVICES"
#Get latest revision
REVISION=$(aws --profile abdel ecs describe-task-definition --task-definition ${FAMILY} | jq .taskDefinition.revision)
echo "REVISION is $REVISION"

#Create or update service
if [ "$SERVICES" == "" ]; then
  echo "entered existing service"
  aws --profile abdel ecs update-service --cluster ${CLUSTER} --region ${REGION} --service ${SERVICE_NAME} --task-definition ${FAMILY}:${REVISION} --desired-count 2 --deployment-configuration maximumPercent=200,minimumHealthyPercent=100
else
  echo "entered new service"
  aws --profile abdel ecs create-service --task-definition ${FAMILY} --cli-input-json file://rater-ecs-service.json
fi
