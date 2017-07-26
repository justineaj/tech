//import java.util.HashMap;
//import java.util.Map;
//
//public class WrapperEquals {
//
//	public static void main(String args[]) {
//
//		Map m = new HashMap();
//		MyKeys m1 = new MyKeys(1);
//		MyKeys m2 = new MyKeys(2);
//		MyKeys m3 = new MyKeys(1);
//		MyKeys m4 = new MyKeys(new Integer(2));
//		m.put(m1, "car");
//		m.put(m2, "boat");
//		m.put(m3, "plane");
//		m.put(m4, "hovercraft");
//		System.out.print(m.size());
//		System.out.println("-------------------------------------");
//		Integer i1=null;
//		Integer i2=null;
//
//		i1=new Integer(10);
//		i2=new Integer(10);
//		System.out.println(i1==i2);
//
//		i1=10;
//		i2=10;
//		System.out.println(i1==i2);
//
//		i1=1000;
//		i2=1000;
//		System.out.println(i1==i2);
//
//
//
//
//
//	}
//
//}
//	class MyKeys {
//		Integer key;
//
//		MyKeys(Integer k) {
//			key = k;
//		}
//
//		public boolean equals(Object o) {
//			return ((MyKeys) o).key == this.key;
//		}
//	}
//
//
//	class Truthy {
//		public static void main(String[] args) {
//		int x = 7;
//		assert(x == 6) ? "x == 6" : "x != 6";
//		}
//		}
//