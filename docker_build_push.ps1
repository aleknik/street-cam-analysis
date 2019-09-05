Start-Process -FilePath ".\street-cam-aggregator\mvnw.cmd" `
              -ArgumentList "-f ..\common\pom.xml clean install" `
              -WorkingDirectory ".\street-cam-aggregator" `
              -Wait		  
			  
Start-Process -FilePath ".\street-cam-loader\mvnw.cmd" `
              -ArgumentList " clean install dockerfile:build" `
              -WorkingDirectory ".\street-cam-loader" `
			  -Wait
			 
			 
Start-Process -FilePath ".\street-cam-aggregator\mvnw.cmd" `
              -ArgumentList "clean install dockerfile:build" `
              -WorkingDirectory ".\street-cam-aggregator" `
			  -Wait

docker build -t aleknik/street-cam-classification:latest .\street-cam-classification

docker push aleknik/street-cam-aggregator
docker push aleknik/street-cam-loader
docker push aleknik/street-cam-classification