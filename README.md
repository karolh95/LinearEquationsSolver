# LinearEquationsSolver

## About

You’ve come so far! Yet sometimes it’s nice to get back to old and simple basics: shall we remember some linear algebra? In this project, you will write a program that solves linear equations (you wish you had it back at school, don’t you?) It won’t be working with powers and radicals, but on the other hand, it will be able to handle matrices and complex numbers.

## Learning outcomes

Practice the ever-useful essentials (classes, arrays, files) and learn to handle complex numbers and matrices.

## What you’ll do and what you’ll learn

- [x] [**Stage 1/5: Simple and real**](#stage-15-simple-and-real)  
  Start with real numbers and simple equations of (a*x = b) type.
- [x] [**Stage 2/5: X and Y**](#stage-25-x-and-y)  
  Enable the program to solve systems with two variables.
- [x] [**Stage 3/5: Equations**](#stage-35-equations)  
  Practice working with multidimensional arrays, files and the command line: get data from a file and solve multiple linear equations
- [x] **Stage 4/5: When things get complicated**  
  Learn to handle special cases where there is no or infinite possible solutions for the equations.
- [x] **Stage 5/5: Complex numbers**  
  Finally, teach your program to solve equations with complex numbers.

## Demonstration

![Demonstration](demonstration1.gif)

## **Stage 1/5: Simple and real**

A linear equation is an equation for a straight line, often presented as `y = ax + b`. It is called linear because it contains only variables to the power of 1. The ***x*** and ***y*** above are these variables, while ***a*** and ***b*** are called coefficients.

Linear equations can be found in different fields of science and technology. You can find some basic examples here. In this project, you will write a lot more powerful solver, but in this stage, you will start with a simple one.

Write a program that solves the equation `a*x = b`.

Numbers ***a*** and ***b*** should be read from the first line of the standard input. You should output the value ***x***, with which the equation is true. For example, if the input contains numbers ***5*** and ***3***, this means that you should interpret this as an equation `5*x=3`. For this example, the answer would be `0.6` since `5*0.6=3`.

## **Stage 2/5: X and Y**

Let's solve the problem with one additional variable and one additional equation. The variables would be ***x*** and ***y***. In general this equation would look like this:

![Equation1](src/images/stage2/E1.png)

Where ***a, b, c, d, e, f*** are numbers. The general algorithm is to separate the variables so that the first variable is solved in the first line and the second variable is solved in the second line.

The main concept here is to subtract rows. You already know how to subtract numbers and subtraction of rows is pretty similar. Below is an example in which we subtract the first row from the second one.

![Equation2](src/images/stage2/E2.png)

As you can see, we subtract `ax + by` from the left side of the second equation and also subtract ***c*** from the right side that equation. Since we subtracted equal amounts from both sides, the equation remains correct. You also can simplify this as shown below:

![Equation3](src/images/stage2/E3.png)

However, this all comes together when you realize you can subtract only a part of an equation. Let's subtract the first equation multiplied by `d / a` from the second equation.

![Equation4](src/images/stage2/E4.png)

Notice that `d - a *d / a` becomes `d - d` and becomes ***0***. Therefore, we can exclude ***x*** from the second equation.

![Equation5](src/images/stage2/E5.png)

And there we can find the ***y*** value. Just divide both sides by `e - b * d / a`.

![Equation6](src/images/stage2/E6.png)

Now, you can find the ***x*** value from the first equation since you know the ***y*** value. This is a similar problem like in the previous stage.

The first line of the input contains numbers ***a, b, c***. The second line of the input contains numbers ***d, e, f***. All 6 numbers are doubles. You should output the solution: ***x*** and ***y*** in a single line.

## **Stage 3/5: Equations**

In this stage, the problem becomes more difficult. You should generalize the solution for any amount of variables. The important part is to understand that in most cases if the number of equations equals the number of variables there is only one solution. We will consider special cases in the next stage.

Such multiple linear equations connected together are called a system of linear equations.

You can see an example of the general system of linear equations below. The variables are named ![x1](src/images/stage3/x1.png), ![x2](src/images/stage3/x2.png), ..., ![xn](src/images/stage3/xn.png) 
The coefficients are named ![ai1](src/images/stage3/ai1.png), ![ai2](src/images/stage3/ai2.png), ..., ![ain](src/images/stage3/ain.png) for the *i*-th row. And the constants are named ![b1](src/images/stage3/b1.png), ![b2](src/images/stage3/b2.png), ..., ![bn](src/images/stage3/bn.png).
 
![Equation1](src/images/stage3/equation1.png)
 
 Firstly, the algorithm should null the first column of coefficients except for the first coefficient, which should be equal to 1. Notice letters **c** and **d** instead of **a** and **b**. It means that through some calculations these coefficients became other coefficients and thus we cannot use letters **a** and **b** since they refer to the initial coefficients.
 
 ![Equation2](src/images/stage3/equation2.png)
 
 After that, you need to null the second column all the way from the third row. The second row should contain the coefficient equal to 1.
 
 ![Equation3](src/images/stage3/equation3.png)
 
 The same goes for the rest of the columns. In the end, you should get something like that:
 
 ![Equation4](src/images/stage3/equation4.png)
 
 The second part of the algorithm is to iterate rows from the last to the first and null the top part of the linear system. In the end, there should be only diagonal elements of the linear system.
 
 ![Equation5](src/images/stage3/equation5.png)
 
 And the right part of the system is the solution to this system.
 
 In this stage, you need to write a program that reads coefficients from a file, solves the system of linear equations, and writes the answer to another file. You should pass paths to files using command-line arguments. Write to the file only answers separated by `\n`. Output all the steps only to the console, not in the file.
 
 The first line of the file should contain the number **N**, a number of variables and also a number of equations. Every other **N** lines contain **N+1** numbers, i.e. **N** coefficients of the current row and a constant as the last number in this line. The program also should output all rows manipulation it is doing when solving a system of linear equations.
 
 