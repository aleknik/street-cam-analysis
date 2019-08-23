import numpy as np
from gluoncv import model_zoo, data

# net = model_zoo.get_model('faster_rcnn_resnet101_v1d_coco', pretrained=True, ctx=mx.gpu(0))
net = model_zoo.get_model('faster_rcnn_resnet101_v1d_coco', pretrained=True)


# net = model_zoo.get_model('yolo3_darknet53_voc', pretrained=True)

def count_frequency(my_list, labels):
    # Creating an empty dictionary
    freq = {i: 0 for i in labels}
    for item in my_list:
        freq[item] += 1

    return freq


def predict(img):
    x, orig_img = data.transforms.presets.rcnn.transform_test(img)
    # box_ids, scores, bboxes = net(x.as_in_context(mx.gpu(0)))
    box_ids, scores, bboxes = net(x)

    box_ids = box_ids[0, :, 0].astype(int).asnumpy()
    scores = scores[0, :, 0].asnumpy()
    labels = np.asarray(net.classes)

    threshold = .75

    detected = labels[box_ids[scores > threshold]]

    return count_frequency(detected, labels)
