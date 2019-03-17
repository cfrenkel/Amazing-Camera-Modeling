package primitives;

public class Material {

	//*******properties********
	double Kd;
	double Ks;
	int nShininess;
	double Kr;
	double Kt;
	
	//*******get and set*******
	public double getKd() {
		return Kd;
	}
	public void setKd(double kd) {
		Kd = kd;
		
	}
	
	
	public int getnShininess() {
		return nShininess;
	}
	public void setnShininess(int nShininess) {
		this.nShininess = nShininess;
	}
	public double getKs() {
		return Ks;
	}
	public void setKs(double ks) {
		Ks = ks;
	}
	
	//*******Constructors********
	
	public double getKr() {
		return Kr;
	}
	public void setKr(double kr) {
		Kr = kr;
	}
	public double getKt() {
		return Kt;
	}
	public void setKt(double kt) {
		Kt = kt;
	}
	public Material(double kd, double ks, int n, double kr, double kt) {
		super();
		Kd = kd;
		Ks = ks;
		nShininess = n;
		Kr= kr;
		Kt = kt;
	}
	
	public Material() {
		Kd = 1;
		Ks = 1;
		nShininess = 1;
		Kr =0;
		Kt =0;
		
	}
	
	public Material(Material m) {
		super();
		Kd = m.Kd;
		Ks = m.Ks;
		Kr = m.Kr;
		Kt = m.Kt;
	}

	
	//*******basic function*******

		@Override
	public String toString() {
		return "Material [Kd=" + Kd + ", Ks=" + Ks + ", nShininess=" + nShininess + "]";
	}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Material other = (Material) obj;
			if (Double.doubleToLongBits(Kd) != Double.doubleToLongBits(other.Kd))
				return false;
			if (Double.doubleToLongBits(Ks) != Double.doubleToLongBits(other.Ks))
				return false;
			if (nShininess != other.nShininess)
				return false;
			return true;
		}

	
	
	
}
