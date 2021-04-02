from logic import *


noise = generate_noise()

#noise.show()

greyscale = generate_greyscale_from_image('square.jpg')

#greyscale.show()

convolved_img = convolve('square.jpg')

#convolved_img.show()



max_pooled_img = max_pool('square.jpg')

max_pooled_img.show()