import by.gsu.pms.Line;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Line> lines = new ArrayList<Line>();

        lines.add(new Line("go ahead make my day"));
        lines.add(new Line("together we can manage it"));
        lines.add(new Line("the stuff that dreams are made of"));
        lines.add(new Line("my precious"));
        lines.add(new Line("Egor hello you are very handsome"));

        for (Line line : lines) {
            System.out.println(line);
        }

        Line linetoDelete = null;
        int maxLength = 0;

        for(Line line : lines){
            String lowerCasedLine = line.getLine().toLowerCase();
            if (lowerCasedLine.charAt(0) == lowerCasedLine.charAt(lowerCasedLine.length() - 1)) {
                if (lowerCasedLine.length() > maxLength) {
                    maxLength = lowerCasedLine.length();
                    linetoDelete = line;
                }
            }
        }

        lines.remove(linetoDelete);

        System.out.println("\n");

        for (Line line : lines) {
            System.out.println(line);
        }

    }

}
