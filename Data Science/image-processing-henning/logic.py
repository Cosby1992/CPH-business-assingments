import numpy as np
from PIL import Image, ImageOps
import skimage.measure


# https://numpy.org/devdocs/reference/random/generated/numpy.random.rand.html


def generate_noise(custom_dimensions=(32, 32)):
    random_arr = np.random.rand(
        int(custom_dimensions[0]), int(custom_dimensions[1]))
    img = Image.fromarray(np.uint8(random_arr * 255), 'L')
    return img


def generate_greyscale_from_image(file_path, preserve_dimensions=False, use_greyscale=False):
    img = Image.open(file_path)
    if not preserve_dimensions:
        img = img.resize((32, 32))
    if not use_greyscale:
        img = ImageOps.grayscale(img)
    return img


def convolve(file_path=None, preserve_dimensions=False, use_greyscale=False, custom_dimensions=(32, 32)):
    kernel = np.array([
        0, 1, 0,
        0, 1, 0,
        0, 1, 0
    ])
    kernel = kernel.reshape(3, 3)
    img = None
    if file_path:
        img = generate_greyscale_from_image(
            file_path, preserve_dimensions, use_greyscale)
    else:
        img = generate_noise(custom_dimensions)

    img_arr = np.array(img)
    img_shape = np.shape(img_arr)

    img_arr = np.ravel(img_arr)
    kernel = np.ravel(kernel)

    res = np.convolve(img_arr, kernel)

    pixel_count = 0

    if preserve_dimensions:
        img_size = img.size
        pixel_count = img_size[0]*img_size[1]
    else:
        pixel_count = int(custom_dimensions[0]) * int(custom_dimensions[1])

    res = res[:pixel_count]

    new_image = Image.fromarray(np.uint8(res.reshape(img_shape)))
    return new_image


# https://stackoverflow.com/questions/42463172/how-to-perform-max-mean-pooling-on-a-2d-array-using-numpy
def max_pool(file_path=None, preserve_dimensions=False, use_greyscale=False, custom_dimensions=(32, 32)):
    convuluted_image = convolve(
        file_path, preserve_dimensions, use_greyscale, custom_dimensions)

    # Showing image size before max pooling
    print("size before max-pooling: ", convuluted_image.size)

    intermediate = np.array(convuluted_image)
    img = skimage.measure.block_reduce(intermediate, (2, 2), np.max)
    img = Image.fromarray(img)

    # 
    print("size after max-pooling: ", img.size)

    return img