import cv2  # works with images
from matplotlib import pyplot  # for visualisation
# load your image, 0 is for grey scale mode
img = cv2.imread('7fe3c3f6-Stego.png', 0)
# visualisation function


def myimage(image):
    # image view
    pyplot.imshow(image)
    pyplot.show()
    # pixel view
    print('image size: ', image.shape)
    print('pixel matrix:\n', image)


# show the original image
myimage(img)
# resize the image
SIZE = 320
img = cv2.resize(img, (SIZE, SIZE))
# show the resized image
myimage(img)
