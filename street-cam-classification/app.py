import base64
import io
import json

import mxnet as mx
from PIL import Image
from flask import Flask, Response
from flask import request

from classification import predict

app = Flask(__name__)


@app.route('/api/detect', methods=['POST'])
def detect():
    json_data = request.get_json()

    decoded = base64.b64decode(json_data['data'])
    image = Image.open(io.BytesIO(decoded))
    data = predict(mx.nd.array(image))

    js = json.dumps(data)

    resp = Response(js, status=200, mimetype='application/json')

    return resp


if __name__ == '__main__':
    app.run()
