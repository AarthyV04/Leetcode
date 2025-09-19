class Spreadsheet {
    private Map<String, Integer> cells;
    public Spreadsheet(int rows) {
        cells = new HashMap<>();
    }
    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    public int getValue(String formula) {
        String expr = formula.substring(1);  
        String[] parts = expr.split("\\+");
        int total = 0;
        for (String token : parts) {
            if (Character.isDigit(token.charAt(0))) {
                total += Integer.parseInt(token);
            } else {
                total += cells.getOrDefault(token, 0);
            }
        }
        return total;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */