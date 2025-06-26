public class MonteCarloIntegration {

    private static final int MAX_ITERATIONS = 100_000;
    private static final double MIN_CHANGE = 1e-5;


    public static double function(double x) {
        //return x;
        return Math.sin(Math.PI * x);
    }

    private static boolean samplePoint(){
        double x = Math.random();
        double y = Math.random();

        return y <= function(x);
    }

    public static void main(String[] args) {

        double approxInt = 0;
        double change;
        int allPoints = 0;
        int pointsUnderCurve = 0;
        double newApproxInt;
        int countLoop = 0;

        do {

            if (samplePoint())
                pointsUnderCurve++;

            allPoints++;

            newApproxInt = ((double) pointsUnderCurve / allPoints);

            change = Math.abs(approxInt - newApproxInt);

            approxInt = newApproxInt;

            System.out.printf("Iteration %d: %.5f (%f)%n", allPoints, approxInt, change);
            countLoop++;
        } while ((change > MIN_CHANGE && allPoints < MAX_ITERATIONS) || countLoop < 150);

    }
}
