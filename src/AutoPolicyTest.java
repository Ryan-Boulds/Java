public class AutoPolicyTest {
    public static void main(String[] args) {

        AutoPolicy policy1 = new AutoPolicy(1111, "Toyota Camry", "NJ");
        AutoPolicy policy2 = new AutoPolicy(235246, "Ford Fusion", "ME");
        policyInNoFaultState(policy1);
        policyInNoFaultState(policy2);
    }
        // Display each policy item for no-fault.
        public static void policyInNoFaultState (AutoPolicy policy1){
            System.out.println("The auto policy:");
            System.out.printf("Account #: %d; Car: %s;%nState %s %s a no-fault state%n%n",
                    policy1.getAccountNumber(),
                    policy1.getMakeAndModel(),
                    policy1.getState(),
                    (policy1.isNoFaultState() ? "is" : "is not"));

        }
    }

