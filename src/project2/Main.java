package project2;

abstract class Pair {
    public abstract Pair add(Pair other);
    public abstract Pair subtract(Pair other);
    public abstract Pair multiply(Pair other);
    
    @Override
    public abstract String toString();
    
    @Override
    public abstract boolean equals(Object obj);
}

class Complex extends Pair {
    private double real; 
    private double imaginary; 

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public Pair add(Pair other) {
        if (other instanceof Complex) {
            Complex c = (Complex) other;
            return new Complex(this.real + c.real, this.imaginary + c.imaginary);
        }
        return null;
    }

    @Override
    public Pair subtract(Pair other) {
        if (other instanceof Complex) {
            Complex c = (Complex) other;
            return new Complex(this.real - c.real, this.imaginary - c.imaginary);
        }
        return null;
    }

    @Override
    public Pair multiply(Pair other) {
        if (other instanceof Complex) {
            Complex c = (Complex) other;
            double newReal = this.real * c.real - this.imaginary * c.imaginary;
            double newImaginary = this.real * c.imaginary + this.imaginary * c.real;
            return new Complex(newReal, newImaginary);
        }
        return null;
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Complex) {
            Complex c = (Complex) obj;
            return this.real == c.real && this.imaginary == c.imaginary;
        }
        return false;
    }
}

class Rational extends Pair {
    private int numerator; 
    private int denominator; 

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public Pair add(Pair other) {
        if (other instanceof Rational) {
            Rational r = (Rational) other;
            int newNumerator = this.numerator * r.denominator + r.numerator * this.denominator;
            int newDenominator = this.denominator * r.denominator;
            return new Rational(newNumerator, newDenominator);
        }
        return null;
    }

    @Override
    public Pair subtract(Pair other) {
        if (other instanceof Rational) {
            Rational r = (Rational) other;
            int newNumerator = this.numerator * r.denominator - r.numerator * this.denominator;
            int newDenominator = this.denominator * r.denominator;
            return new Rational(newNumerator, newDenominator);
        }
        return null;
    }

    @Override
    public Pair multiply(Pair other) {
        if (other instanceof Rational) {
            Rational r = (Rational) other;
            return new Rational(this.numerator * r.numerator, this.denominator * r.denominator);
        }
        return null;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Rational) {
            Rational r = (Rational) obj;
            return this.numerator * r.denominator == this.denominator * r.numerator;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Pair[] pairs = new Pair[4];

        pairs[0] = new Complex(2, 3);
        pairs[1] = new Complex(1, 4);
        pairs[2] = new Rational(1, 2);
        pairs[3] = new Rational(2, 3);

        for (Pair pair : pairs) {
            System.out.println("Value: " + pair);
        }

        Pair complexSum = pairs[0].add(pairs[1]);
        Pair rationalSum = pairs[2].add(pairs[3]);
        
        System.out.println("Sum of Complex Numbers: " + complexSum);
        System.out.println("Sum of Rational Numbers: " + rationalSum);
    }
}
