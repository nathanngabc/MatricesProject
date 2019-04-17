package TwoDimensionMatrices;



public class RandomShape {
   //private double [][] vertices = new double[2][4];
   private vertix[] vertices;
   
   public RandomShape (vertix [] vertices2, int length) {
      // this.vertices = vertices;
	   vertices = new vertix[length];
	   for (int i = 0; i<vertices.length; i++) {
		   this.vertices[i] = vertices2[i];
	   }
   }
   
   public double[][] rotate (double degrees, String direction) {
	   double[][] transformativeMatrix = null;
	   for (int i = 0; i<vertices.length; i++) {
		   double[][] vertex = new double [3][1];
		   vertex[0][0] = vertices[i].x;
		   vertex[1][0] = vertices[i].y;
		   vertex[2][0] = vertices[i].z;
		   
		   if (direction == "XY") {
			   transformativeMatrix = createTransformMatrixXY (degrees);
			   vertex = multiply (transformativeMatrix, vertex);
		   }
		   else if (direction == "YZ") {
			   transformativeMatrix = createTransformMatrixYZ (degrees);
			   vertex = multiply (transformativeMatrix, vertex);
		   }
		   else {
			   transformativeMatrix = createTransformMatrixXZ (degrees);
			   vertex = multiply (transformativeMatrix, vertex);
		   }
	
		   vertices[i].x = vertex[0][0];
		   vertices[i].y = vertex[1][0];
		   vertices[i].z = vertex[2][0];
	   }
	   return transformativeMatrix;
   }
   
   public double[][] createTransformMatrixXY (double degrees) {
       double[][] tempMatrix = new double[3][3];
       double radians = Math.toRadians(degrees);
       
       double cosine = Math.cos(radians);
       double sin = Math.sin(radians);
       
       tempMatrix [0][0] = cosine;
       tempMatrix [0][1] = -sin;
       tempMatrix [1][0] = sin;
       tempMatrix [1][1] = cosine;
       tempMatrix [2][0] = 0;
       tempMatrix [2][1] = 0;
       tempMatrix[2][2] = 1;
       tempMatrix [0][2] = 0;
       tempMatrix [1][2] = 0;
       
       return tempMatrix;
   }
   
   public double[][] createTransformMatrixYZ (double degrees) {
       double[][] tempMatrix = new double[3][3];
       double radians = Math.toRadians(degrees);
       
       double cosine = Math.cos(radians);
       double sin = Math.sin(radians);
       
       tempMatrix[0][0] = 1;
       tempMatrix[0][1] = 0;
       tempMatrix[0][2] = 0;
       tempMatrix[1][0] = 0;
       tempMatrix[1][1] = cosine;
       tempMatrix[1][2] = sin;
       tempMatrix[2][0] = 0;
       tempMatrix[2][1] = -sin;
       tempMatrix[2][2] = cosine;
       
       return tempMatrix;
   }
   
   public double[][] createTransformMatrixXZ (double degrees) {
       double[][] tempMatrix = new double[3][3];
       double radians = Math.toRadians(degrees);
       
       double cosine = Math.cos(radians);
       double sin = Math.sin(radians);
       
       tempMatrix[0][0] = cosine;
       tempMatrix[0][1] = 0;
       tempMatrix[0][2] = -sin;
       tempMatrix[1][0] = 0;
       tempMatrix[1][1] = 1;
       tempMatrix[1][2] = 0;
       tempMatrix[2][0] = sin;
       tempMatrix[2][1] = 0;
       tempMatrix[2][2] = cosine;
       
       return tempMatrix;
   }
   
   
   public vertix[] getVertices () {
       return vertices;
   }
   /*
   public void setVertices(double[][]vertices) {
	   this.vertices = vertices;
   }
   */
   
   public double[][] multiply (double[][] matrixOne, double[][] matrixTwo) {  
       double[][] matrixThree = new double [matrixOne.length][matrixTwo[0].length];
       
       for (int i = 0; i<matrixOne.length; i++) {
           for (int j = 0; j<matrixTwo[i].length; j++) {
               double sum = 0;
               for (int k = 0; k<matrixOne[i].length; k++) {
                   for (int l = 0; l<matrixTwo.length; l++) {
                       if (k==l) sum += matrixOne[i][k] * matrixTwo[l][j];
                   }
               }
               matrixThree[i][j] = sum;
           }
       }
       return matrixThree;
   }
   
}
