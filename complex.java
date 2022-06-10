public class complex {
    public float real;
    public float img;
    public complex(float r, float i) {
        real = r;
        img = i;
    }
    public complex() {
    }
    public float[] addition(float r, float i) {
        real += r;
        img += i;
        return new float[]{real, img};
    }
    public float[] substraction(float r, float i) {
        real -= r;
        img -= i;
        return new float[]{real, img};
    }
    public float[] division(float r, float i) {
        float tempImg;
        float numeratorReal = 0;
        float denominatorReal = 0;
        float numeratorImg = 0;
        tempImg = i * (-1);
        numeratorReal += (real * r) + (img * i);
        numeratorImg += (img * r) + (real * tempImg);
        denominatorReal += (r * r) + (i * i);
        return new float[]{numeratorReal, denominatorReal, numeratorImg, denominatorReal};
    }
    public float[] multi(float r, float i) {
        float tempImg;
        float partReal;
        float partImg;
        tempImg = i * (-1);
        partReal = (real * r) + (img * tempImg);
        partImg = (real * i) + (img * r);
        return new float[]{partReal, partImg};
    }
    public float[] power() {
        float tempReal;
        float tempImg;
        tempReal = (real * real) + (img * (-img));
        tempImg = 2 * real * img;
        real = tempReal;
        img = tempImg;
        return new float[]{real, img};
    }
    public float modulo() {
        return (float) (Math.sqrt((real * real) + (img * img)));
    }
    public double argRad() {
        double arg = 0;
        if (real > 0) { // -θ or θ
            arg = Math.atan(img / real);
        } else if (real < 0 && img >= 0) {// θ+π
            arg = Math.atan(img / real) + 3.14;
        } else if (real < 0 && img < 0) { // θ-π
            arg = Math.atan(img / real) - 3.14;
        } else if (real == 0 && img > 0) { // 2/π
            arg = 3.14 / 2;
        } else if (real == 0 && img < 0) { // -π/2
            arg = -3.14 / 2;
        }
        return arg;
    }
    public double argDeg() {
        return (argRad() * 180) / 3.14;
    }
}
