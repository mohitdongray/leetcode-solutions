class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, boolean[]> rowSeats = new HashMap<>();
        int totalGroups = 0;

        for (int[] res : reservedSeats) {
        
        int row = res[0];
        int seat = res[1];

        boolean[] seats = rowSeats.get(row);
        if (seats == null) {
            seats = new boolean[11];
            rowSeats.put(row, seats);
        }
        seats[seat] = true;
      }
    for( boolean[] seats:rowSeats.values()){

        boolean left = !seats[2] && !seats[3] && !seats[4] && !seats[5];
        boolean mid = !seats[4] && !seats[5] && !seats[6] && !seats[7];
        boolean right = !seats[6] && !seats[7] && !seats[8] && !seats[9];

        if (left && right) {
            totalGroups += 2;
        } else if (left || mid || right) {
            totalGroups += 1;
        }
    }
    totalGroups+=(n-rowSeats.size())*2;
    return totalGroups;
 } 
}