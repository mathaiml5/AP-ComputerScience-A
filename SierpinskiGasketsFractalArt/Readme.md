# Sierpinski Gasket & Box Fractal Art

This program uses a simple Drawing library (StdDraw.java) from Princeton CS Dept to construct various Fractal Art pictures using a recrursive construct for Sierpinski's gasket and Box fractal.

In the Siepinski's gasket method, we look for mid-points of each side of the starting triangle and construct smaller triangles whose vertices are the midpoints of the parent triangle in each succesive step.
In effect, we call the sierpinski method recursively until the depth=d value reaches 0 (or d levels of triangles!)

![Sierpinski Fractal](https://github.com/mathaiml5/AP-ComputerScience-A/blob/main/SierpinskiGasketsFractalArt/images/triangles-gasket.png?raw=true)


In the Box Fractal method, we choose one of four random directions from each edge of a square box and scale the original square is scaled by a factor r=1/3. 
This is done followed by the necessary translations to arrange each set of smaller squares so that we get a snowflake pattern.

![Box Fractal](https://github.com/mathaiml5/AP-ComputerScience-A/blob/main/SierpinskiGasketsFractalArt/images/box-gasket-color.png?raw=true)



