import time

import numpy as np
from gluoncv import model_zoo, data, utils

net = model_zoo.get_model('faster_rcnn_resnet101_v1d_coco', pretrained=True)


# net = model_zoo.get_model('yolo3_darknet53_voc', pretrained=True)

def count_frequency(my_list):
    # Creating an empty dictionary
    freq = {}
    for item in my_list:
        if item in freq:
            freq[item] += 1
        else:
            freq[item] = 1

    return freq


def predict(img):
    start = time.time()
    x, orig_img = data.transforms.presets.rcnn.transform_test(img)
    box_ids, scores, bboxes = net(x)

    box_ids = box_ids[0, :, 0].astype(int).asnumpy()
    scores = scores[0, :, 0].asnumpy()
    labels = np.asarray(net.classes)
    end = time.time()

    threshold = .75

    detected = labels[box_ids[scores > threshold]]

    return 'counts: %s, time: %s' % (str(count_frequency(detected)), str(end - start))
