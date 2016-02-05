public static double sqrt(double c) {
	if (c < 0) return Double.NaN;
	
	double EPS = 1E-15;
	double t = c;
	
	while(Math.abs(t - c / t) > EPS * t)
		t = (c/t + t) / 2.0;
	return t;
}

public static double sqrt(double c, double EPS) {
	if (c < 0) return Double.NaN;
	double t = c;
	
	while (Math.abs(t - c/t) > EPS * t)
		t = (c/t + t) / 2.0;
	return t
}