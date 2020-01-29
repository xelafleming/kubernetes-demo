echo "Deleting previous demo cluster if exists..."
minikube delete -p demo

echo "Starting and configuring new demo cluster..."
minikube start -p demo --cpus=2 --memory=4096mb
kubectl config set-context --current --namespace=kube-demo
eval $(minikube docker-env -p demo)

echo "Building and deploying simple-web-server..."
cd web-server
docker build . -t simple-web-server:v1
kubectl apply -k kustomize

echo "Deploying RabbitMQ..."
cd ../rabbitmq
./setup.sh

echo "Building and deploying poller..."
cd ../poller
docker build . -t poller:v1
kubectl apply -k kustomize

echo "Building and deploying api..."
cd ../api
docker build . -t ui-api:v1
kubectl apply -k kustomize
