package com.erich.tetrarunner;

/**
 * Created by Erich on 11/24/2014.
 * Contains static methods for building simple geometric objects.
 */
public class GeometryBuilder
{
    //Points for various geometry

    final static float[] planePoints =
    {
            -0.5f, 0.0f, -0.5f,
            -0.5f, 0.0f, 0.5f,
            0.5f, 0.0f, 0.5f,
            0.5f, 0.0f, -0.5f
    };

    final static float[] squarePoints =
    {
            -0.5f, -0.5f, 0.0f, //bottom left
            -0.5f, 0.5f, 0.0f, //top left
            0.5f, -0.5f, 0.0f, //bottom right
            0.5f, 0.5f, 0.0f //top right
    };

    //Flush with cube
    final static float[] rightTetraPoints =
    {
            -0.5f, 0.5f, 0.5f, //top
            0.5f, -0.5f, 0.5f,
            -0.5f, -0.5f, 0.5f,
            -0.5f, -0.5f, -0.5f //nose
    };

    //Centered at origin; equilateral all around.
    final static float[] tetraPoints =
    {
            0.0f, 0.8083f, 0.0f, //top
            0.7f, -0.4041f, -0.4041f,
            -0.7f, -0.4041f, -0.4041f,
            0f,  -0.4041f, 0.8083f
    };

    final static float[] cubePoints = {
            -0.5f, -0.5f, 0.5f, //bottom left front
            -0.5f, 0.5f, 0.5f, //top left front
            0.5f, 0.5f, 0.5f, //top right front
            0.5f, -0.5f, 0.5f, //bottom right front
            -0.5f, -0.5f, -0.5f, //bottom left back
            -0.5f, 0.5f, -0.5f, //top left back
            0.5f, 0.5f, -0.5f, //top right back
            0.5f, -0.5f, -0.5f //bottom right back
    };

    //Each get method will first check if the static triangles array has been initialized
    //  already; if it has, the method simply returns it. If not, initialize the triangles array.

    static float[] planeTriangles = null;
    static float[] planeTriangleNormals = null;
    public static PointsPackage getPlane()
    {
        if (planeTriangles != null && planeTriangleNormals != null)
            return new PointsPackage(planeTriangles, planeTriangleNormals);

        int[] elements = {
                0,1,2,
                0,2,3
        };

        planeTriangles = new float[24];
        int j = 0;
        for (int i = 0; i < planeTriangles.length; i+=4)
        {
            planeTriangles[i] = planePoints[elements[j]*3];
            planeTriangles[i+1] = planePoints[(elements[j]*3)+1];
            planeTriangles[i+2] = planePoints[(elements[j]*3)+2];
            planeTriangles[i+3] = 1.0f;
            j++;
        }

        planeTriangleNormals = getNormalsOfShape(planeTriangles);

        return new PointsPackage(planeTriangles, planeTriangleNormals);
    }

    static float[] squareTriangles = null;
    static float[] squareTriangleNormals = null;
    public static PointsPackage getSquare()
    {
        if (squareTriangles != null && squareTriangleNormals != null)
            return new PointsPackage(squareTriangles, squareTriangleNormals);

        int[] elements = {
                0,1,2,
                2,1,3
        };

        squareTriangles = new float[24];
        int j = 0;
        for (int i = 0; i < squareTriangles.length; i+=4)
        {
            squareTriangles[i] = squarePoints[elements[j]*3];
            squareTriangles[i+1] = squarePoints[(elements[j]*3)+1];
            squareTriangles[i+2] = squarePoints[(elements[j]*3)+2];
            squareTriangles[i+3] = 1.0f;
            j++;
        }

        squareTriangleNormals = getNormalsOfShape(squareTriangles);

        return new PointsPackage(squareTriangles, squareTriangleNormals);
    }

    static float[] rightTetraTriangles = null;
    static float[] rightTetraTriangleNormals = null;
    public static PointsPackage getRightTetrahedron()
    {
        if (rightTetraTriangles != null && rightTetraTriangleNormals != null)
            return new PointsPackage(rightTetraTriangles, rightTetraTriangleNormals);

        int[] elements = {
                0,2,1,
                2,3,1,
                1,3,0,
                0,3,2
        };

        rightTetraTriangles = new float[48];
        int j = 0;
        for (int i = 0; i < rightTetraTriangles.length; i+=4)
        {
            rightTetraTriangles[i] = rightTetraPoints[elements[j]*3];
            rightTetraTriangles[i+1] = rightTetraPoints[(elements[j]*3)+1];
            rightTetraTriangles[i+2] = rightTetraPoints[(elements[j]*3)+2];
            rightTetraTriangles[i+3] = 1.0f;
            j++;
        }

        rightTetraTriangleNormals = getNormalsOfShape(rightTetraTriangles);

        return new PointsPackage(rightTetraTriangles, rightTetraTriangleNormals);
    }

    static float[] tetraTriangles = null;
    static float[] tetraTriangleNormals = null;
    public static PointsPackage getTetrahedron()
    {
        if (tetraTriangles != null && tetraTriangleNormals != null)
            return new PointsPackage(tetraTriangles, tetraTriangleNormals);

        int[] elements = {
                1,0,3,
                3,0,2,
                2,0,1,
                1,3,2
        };

        tetraTriangles = new float[12 * 4];
        int j = 0;
        for (int i = 0; i < tetraTriangles.length; i+=4)
        {
            tetraTriangles[i] = tetraPoints[elements[j]*3];
            tetraTriangles[i+1] = tetraPoints[(elements[j]*3)+1];
            tetraTriangles[i+2] = tetraPoints[(elements[j]*3)+2];
            tetraTriangles[i+3] = 1.0f;
            j++;
        }

        tetraTriangleNormals = getNormalsOfShape(tetraTriangles);

        return new PointsPackage(tetraTriangles, tetraTriangleNormals);
    }

    static float[] fourSidesTriangles = null;
    static float[] fourSidesTriangleNormals = null;
    public static PointsPackage getFourSides()
    {
        if (fourSidesTriangles != null && fourSidesTriangleNormals != null)
            return new PointsPackage(fourSidesTriangles, fourSidesTriangleNormals);

        fourSidesTriangles = new float[24 * 4];
        int[] elements = {
                1,0,3,
                1,3,2,
                2,3,7,
                2,7,6,
                4,5,6,
                4,6,7,
                5,4,0,
                5,0,1
        };

        int j = 0;
        for (int i = 0; i < fourSidesTriangles.length; i+=4)
        {
            fourSidesTriangles[i] = cubePoints[elements[j]*3];
            fourSidesTriangles[i+1] = cubePoints[(elements[j]*3)+1];
            fourSidesTriangles[i+2] = cubePoints[(elements[j]*3)+2];
            fourSidesTriangles[i+3] = 1.0f;
            j++;
        }

        fourSidesTriangleNormals = getNormalsOfShape(fourSidesTriangles);

        return new PointsPackage(fourSidesTriangles, fourSidesTriangleNormals);
    }

    static float[] cubeTriangles = null;
    static float[] cubeTriangleNormals = null;
    public static PointsPackage getCube()
    {
        if (cubeTriangles != null && cubeTriangleNormals != null)
            return new PointsPackage(cubeTriangles, cubeTriangleNormals);

        cubeTriangles = new float[36 * 4];
        int[] elements = {
                1,0,3,
                1,3,2,
                2,3,7,
                2,7,6,
                0,4,7,
                0,7,3,
                6,5,1,
                6,1,2,
                4,5,6,
                4,6,7,
                5,4,0,
                5,0,1
        };

        int j = 0;
        for (int i = 0; i < cubeTriangles.length; i+=4)
        {
            cubeTriangles[i] = cubePoints[elements[j]*3];
            cubeTriangles[i+1] = cubePoints[(elements[j]*3)+1];
            cubeTriangles[i+2] = cubePoints[(elements[j]*3)+2];
            cubeTriangles[i+3] = 1.0f;
            j++;
        }

        cubeTriangleNormals = getNormalsOfShape(cubeTriangles);

        return new PointsPackage(cubeTriangles, cubeTriangleNormals);
    }

    /**
     *  Get the normals of a geometric shape made up of triangles.
     *      Very expensive; use as little as possible!
     * @param shape - array of points representing 3D geometry in triangles
     * @return - array of normal vectors to the input shape
     */
    public static float[] getNormalsOfShape(float[] shape)
    {
        float[] ret = new float[shape.length];
        for (int i = 0; i < ret.length; i+=12)
        {
            float[] n = getNormalOfTriangle(
                    shape[i], shape[i+1], shape[i+2],
                    shape[i+4], shape[i+5], shape[i+6],
                    shape[i+8], shape[i+9], shape[i+10]
                    );

            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < n.length; j++) {
                    ret[(k * 4) + j + i] = n[j];
                }
            }

        }

        return ret;
    }

    /**
     *  Helper method to get the normal of a single triangle.
     */
    public static float[] getNormalOfTriangle(float u1, float u2, float u3,
                                       float v1, float v2, float v3,
                                       float w1, float w2, float w3)
    {
        float[] ret = new float[4];
        float [] cross = cross(v1-u1, v2-u2, v3-u3, w1-u1, w2-u2, w3-u3);
        ret[0] = cross[0]; ret[1] = cross[1]; ret[2] = cross[2]; ret[3] = 0.0f;

        return ret;
    }

    /**
     *  Calculate the cross product of two vectors.
     */
    public static float[] cross(float u1, float u2, float u3, float v1, float v2, float v3)
    {
        float[] result = new float[3];
        result[0] = (u2*v3) - (u3*v2);
        if (result[0] == -0.0f) result[0] = 0.0f;
        result[1] = (u3*v1) - (u1*v3);
        if (result[1] == -0.0f) result[1] = 0.0f;
        result[2] = (u1*v2) - (u2*v1);
        if (result[2] == -0.0f) result[2] = 0.0f;
        return result;
    }

    /**
     *  Convert a trio of vectors into a column major matrix.
     */
    public static float[] getColMajorMatrix(float[] u, float[] v, float[] w)
    {
        float[] ret = new float[16];

        ret[0] = u[0]; ret[1] = v[0]; ret[2] = w[0]; ret[3] = 0.0f;
        ret[4] = u[1]; ret[5] = v[1]; ret[6] = w[1]; ret[7] = 0.0f;
        ret[8] = u[2]; ret[9] = v[2]; ret[10] = w[2]; ret[11] = 0.0f;
        ret[12] = 0.0f; ret[13] = 0.0f; ret[14] = 0.0f; ret[15] = 1.0f;

        return ret;
    }
}
