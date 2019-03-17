
## Camera Modeling

# Simulates camera operation in 3D modeling, 

using a pixels panel I calculating the meeting point of the ray with the objects. 
By given the prior knowledge of the objects placement, lighting, and the object material, 
I draw the pixel with the matching color.

The modeling also considers factors such as shadow, refraction, reflection, etc.

The project dividing to packages and using unit tests throughout the project.

Libraries:

* java.awt.image.BufferedImage
* javax.imageio.ImageIO
* java.awt.Color