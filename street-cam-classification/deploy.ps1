az group create --name myResourceGroup --location "South Central US"
#az appservice plan create --name myAppServicePlan --resource-group myResourceGroup --sku free --is-linux
az webapp up --resource-group myResourceGroup --plan myAppServicePlan2 --name street-cam-classification --sku free