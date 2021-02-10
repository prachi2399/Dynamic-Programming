public class ques{

    public int stringWithoutConsecutiveZero(int n){
        int oZeroC=1;
        int oOneC=1;
        for(int i=2;i<=n;i++){
            int newZeroC=oOneC;
            int newOneC=oZeroC+oOneC;
            oZeroC=newZeroC;
            oOneC=newOneC;
        }
        return oZeroC+oOneC;
    }
    // Arrange Buiding in format suxh that no 2 buidings are consecutive
    public int arrangeBuilding(int n){
        int oBuilC=1;
        int oSpacenC=1;
        for(int i=2;i<=n;i++){
            int noBuilC=oSpacenC;
            int noSpacenC=oBuilC+oSpacenC;
            oBuilC=noBuilC;
            oSpacenC=noSpacenC;
        }
        int ans= oBuilC+oSpacenC;
        return ans*ans;
    }
}