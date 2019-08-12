import base64
import io

import mxnet as mx
from PIL import Image
from flask import Flask
from flask import request

from classification import predict

app = Flask(__name__)


@app.route('/', methods=['POST'])
def hello_world():
    json = request.get_json()

    decoded = base64.b64decode(json['data'])
    image = Image.open(io.BytesIO(decoded))
    ids = predict(mx.nd.array(image))
    return str(ids)


if __name__ == '__main__':
    app.run()
