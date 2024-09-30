1. Start LocalStack:

 ```sh
 docker run \
  --rm \
  --name local-sqs \
  -p 4566:4566 \
  localstack/localstack
```

2. Create an AWS profile for your local instance using AWS CLI:

```sh
aws configure --profile localstack
```

```plain
AWS Access Key ID [None]: test-key
AWS Secret Access Key [None]: test-secret
Default region name [None]: us-east-1
Default output format [None]: json
```

3. Create an SQS locally

```sh
aws sqs create-queue --queue-name=greetings --profile localstack --endpoint-url=http://localhost:4566
```

4. Add events to SQS

```sh
for i in {1..25} 
do
   aws sqs send-message --queue-url http://localhost:4566/000000000000/greetings --message-body "Greet $i" --profile localstack --endpoint-url=http://localhost:4566         
done

```

This will add 25 test messages to the quote-requests queue.


```sh
./gradlew quarkusDev
```







