package part1;
/**
 * 
 * OrderVisitor Interface
 *
 */

public interface orderVisitor
    {
		public abstract double visit (Laptop laptop);
		public abstract double visit (MobilPhone mobilPhone);
		public abstract double visit (VideoGame videoGame);
	}

