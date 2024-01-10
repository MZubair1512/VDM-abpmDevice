package FMS;
public class VDM {
    
    public static void preTest(boolean condition) throws VDMPreconditionException {
        if (!condition) {
            throw new VDMPreconditionException("Precondition test failed");
        }
    }

    
    public static void invTest(Object object) throws VDMInvariantException {
        if (object == null) {
            throw new VDMInvariantException("Invariant test failed");
        }
        
    }

    
    public static class VDMPreconditionException extends Exception {
        public VDMPreconditionException(String message) {
            super(message);
        }
    }

    
    public static class VDMInvariantException extends Exception {
        public VDMInvariantException(String message) {
            super(message);
        }
    }
}

