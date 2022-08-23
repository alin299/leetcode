package top.alin.solution;

public class MinimumHoursOfTrainingToWinACompetition {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        int n =energy.length;
        for(int i = 0; i < n; i++) {
            while(initialEnergy <= energy[i]) {
                initialEnergy++;
                ans++;
            }
            while(initialExperience <= experience[i]) {
                initialExperience++;
                ans++;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return ans;
    }
}
