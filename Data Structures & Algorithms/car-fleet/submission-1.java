

class Solution
{
    public int carFleet(int target, int[] position, int[] speed)
    {
        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++)
        {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position descending: closest to target first
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double lastFleetTime = 0.0;

        for (int i = 0; i < n; i++)
        {
            double time = (target - cars[i][0]) * 1.0 / cars[i][1];

            if (time > lastFleetTime)
            {
                fleets++;
                lastFleetTime = time;
            }
        }

        return fleets;
    }
}