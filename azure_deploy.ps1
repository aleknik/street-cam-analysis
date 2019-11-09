az group create --name ScaResourceGroup --location "South Central US"
az appservice plan create --name ScaServicePlan --resource-group ScaResourceGroup --sku free --is-linux
az webapp create --resource-group ScaResourceGroup --plan ScaServicePlan --name street-cam-analysis --multicontainer-config-type compose --multicontainer-config-file docker-compose.yml