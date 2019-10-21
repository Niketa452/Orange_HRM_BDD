package Orange_HRM_BDD;

public class DashBoardPage extends Utils {

LoadProp props=new LoadProp();

public void validateurl(){
    validateURL(props.getProperty("dashboardurl"));
}

}
