public class NBody {
	public static double readRadius(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		double R = in.readDouble();
		return R;
	}

	public static Body[] readBodies(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		double R = in.readDouble();
		
		Body[] bodies = new Body[N];

		for (int i=0; i < N; i++) {
			double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            bodies[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}

		return bodies;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		
		double R = readRadius(filename);
		Body[] bodies = readBodies(filename);

		StdDraw.setScale(-R, R);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");

		for (Body b: bodies) {
			b.draw();
		}
	}
}