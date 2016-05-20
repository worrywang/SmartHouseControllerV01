package com.mars.smarthouse.ui.control;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mars.smarthouse.bean.iocd.Building;
import com.mars.smarthouse.bean.iocd.Floor;
import com.mars.smarthouse.bean.iocd.Street;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.FileChooser;


public class FXMLDeviceManagementPadController implements Initializable {

    @FXML
    private Button chooseFileButton;
    @FXML
    private Button updateFileButton;
    @FXML
    private ChoiceBox unistallFileChoiceBox;
    @FXML
    private Button unistallButton;
    @FXML
    private ChoiceBox buildingIdChoiceBox;
    @FXML
    private ChoiceBox floorIdChoiceBox;
    @FXML
    private ChoiceBox roomIdChoiceBox;
    @FXML
    private Button roomSearchButton;
    @FXML
    private Button roomEnvironmentModifyButton;
    @FXML
    private Label roomInforLabel;
    @FXML
    private ComboBox lightArea;
    @FXML
    private ComboBox humArea;
    @FXML
    private ComboBox tempArea;
    @FXML
    private TabPane deviceMangementTabPane;
    @FXML
    private Tab installDeviceTab;
    @FXML
    private Tab unistallDeviceTab;
    @FXML
    private Tab changeEnvironmentTab;
    @FXML
    private Label interInformationLabel;
    @FXML
    private ProgressIndicator interInformationProgressIndicator;

    private File file;

    private String currentBuildingId;
    private String currentFloorId;
    private String currentRoomId;
    private List<String> choiceFloorListString = new ArrayList<String>();
    private List<String> choiceRoomListString = new ArrayList<String>();
    private ObservableList<String> choiceFloorList = FXCollections.observableArrayList(choiceFloorListString);
    private final ObservableList<String> choiceRoomList = FXCollections.observableArrayList(choiceRoomListString);
    private Map<String, String> machineName_showName = new HashMap<String, String>();

    private static int null_infor = 0;
    private static int add_infor = 1;
    private static int unistall_infor = 2;
    private static int modify_infor = 3;



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
//        Street street = FXMLMainPadController.mainPad.getStreetRoot();
        Street street = new Street();
        List<String> machineNameList = getAllMachineFromStreet(street);
        setInterInformation(null_infor);
        if (street == null) {
            System.exit(0);
        }
        if (machineNameList != null && machineNameList.size() > 0) {

            unistallFileChoiceBox.getItems().addAll(machineNameList);
            unistallFileChoiceBox.getSelectionModel().selectFirst();
        }

//        buildingIdChoiceBox.getItems().addAll(getAllBuildingFromStreet(street));
//        buildingIdChoiceBox.getSelectionModel().selectFirst();
        buildingIdChoiceBox.setOnMouseEntered(new EventHandler<Event>() {
            @Override
            public void handle(Event arg0) {
                // TODO Auto-generated method stub
                buildingIdChoiceBox.getItems().clear();
                buildingIdChoiceBox.getItems().addAll(getAllBuildingFromStreet(street));
                buildingIdChoiceBox.getSelectionModel().selectFirst();
            }
        });

        buildingIdChoiceBox.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                // TODO Auto-generated method stub
//                if (buildingIdChoiceBox.getValue() == null) {
//                    return;
//                }
//                Map<String, Building> buildingList = FXMLMainPadController.mainPad.getStreetRoot().getBuildingList();
//                if (buildingList.size() < 1) {
//                    return;
//                }
//
//                Map<String, Floor> floorList = buildingList.get(buildingIdChoiceBox.getValue().toString()).getFloor_list();
//                if (floorList.size() > 0) {
//                    choiceFloorList.clear();
//                    for (String currentFloorId : floorList.keySet()) {
//                        machineName_showName.putAll(MachineNameTool.machineNameToNodeName(currentFloorId));
//                        String showId = machineName_showName.get(currentFloorId);
//                        choiceFloorList.add(showId);
//                    }
//                }
            }

        });

        floorIdChoiceBox.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                // TODO Auto-generated method stub
//                if (floorIdChoiceBox.getValue() == null || buildingIdChoiceBox.getValue() == null) {
//                    return;
//                }
//                Map<String, Building> buildingList = FXMLMainPadController.mainPad.getStreetRoot().getBuildingList();
//                if (buildingList.size() < 1) {
//                    return;
//                }
//                Map<String, Floor> floorList = buildingList.get(buildingIdChoiceBox.getValue().toString()).getFloor_list();
//                if (floorList.size() < 1) {
//                    return;
//                }
//                Map<String, Room> roomList = floorList.get(floorIdChoiceBox.getValue().toString()).getRoomList();
//                if (roomList.size() > 0) {
//                    choiceRoomList.clear();
//                    for (String currentRoomId : roomList.keySet()) {
//                        machineName_showName.putAll(MachineNameTool.machineNameToNodeName(currentRoomId));
//                        String showId = machineName_showName.get(currentRoomId);
//                        choiceRoomList.add(showId);
//                    }
//                }
            }
        });


        final ListChangeListener<String> floorListListener = new ListChangeListener<String>() {

            @Override
            public void onChanged(
                    Change<? extends String> arg0) {
                // TODO Auto-generated method stub
                floorIdChoiceBox.getItems().clear();
                floorIdChoiceBox.getItems().addAll(choiceFloorList);
                floorIdChoiceBox.getSelectionModel().selectFirst();

//				System.out.println(choiceFloorList.toString());
            }

        };

        final ListChangeListener<String> roomListListener = new ListChangeListener<String>() {

            @Override
            public void onChanged(Change<? extends String> arg0) {
                // TODO Auto-generated method stub
                roomIdChoiceBox.getItems().clear();
                roomIdChoiceBox.getItems().addAll(choiceRoomList);
                roomIdChoiceBox.getSelectionModel().selectFirst();
            }

        };
        choiceFloorList.addListener(floorListListener);
        choiceRoomList.addListener(roomListListener);
    }

    @FXML
    private void roomSearchButtonOnAction() {
        if (buildingIdChoiceBox.getValue() == null) {
            roomInforLabel.setText("No Building Chose");
            return;
        }
        if (floorIdChoiceBox.getValue() == null) {
            roomInforLabel.setText("No Floor Choose");
            return;
        }
        if (roomIdChoiceBox.getValue() == null) {
            roomInforLabel.setText("No Room Choose");
            return;
        }
        roomInforLabel.setText(currentRoomId);
        String currentBuildingId = buildingIdChoiceBox.getValue().toString();
        String currentFloorId = floorIdChoiceBox.getValue().toString();
        String currentRoomId = roomIdChoiceBox.getValue().toString();
        for (String currentName : machineName_showName.keySet()) {
            if (currentName.contains(currentBuildingId)) {
                if (currentName.contains(currentFloorId)) {
                    if (currentName.contains(currentRoomId)) {
                        currentRoomId = currentName;
                        break;
                    }
                }
            }
        }

//        Map<String, Building> buildingList = FXMLMainPadController.mainPad.getStreetRoot().getBuildingList();
//        if (buildingList.size() < 1) {
//            return;
//        }
//        Map<String, Floor> floorList = buildingList.get(buildingIdChoiceBox.getValue().toString()).getFloor_list();
//        if (floorList.size() < 1) {
//            return;
//        }
//        Room currentRoom = floorList.get(currentFloorId).getRoomList().get(currentRoomId);
//        if (currentRoom == null) {
//            return;
//        }
//        StatisticInformation currentRoomStatisticInformation = currentRoom.getStatisticInforamtion();
//        if (currentRoomStatisticInformation == null) {
//            return;
//        }
//        lightArea.setValue(currentRoomStatisticInformation.getLht().getLight());
//        humArea.setValue(currentRoomStatisticInformation.getLht().getHumidity());
//        tempArea.setValue(currentRoomStatisticInformation.getLht().getTemperature());

    }

    @FXML
    private void roomEnvironmentModifyButtonOnAction() {
        //TODO: wyr 改变房间环境
        //需要控制输入的数据为数字
        if (lightArea.getValue() == null || humArea.getValue() == null || tempArea.getValue() == null) {
            return;
        }
        float light = Float.valueOf(lightArea.getValue().toString());
        float humidity = Float.valueOf(humArea.getValue().toString());
        float temperature = Float.valueOf(tempArea.getValue().toString());
        if (buildingIdChoiceBox.getValue() == null) {
            roomInforLabel.setText("No Building Chose");
            return;
        }
        if (floorIdChoiceBox.getValue() == null) {
            roomInforLabel.setText("No Floor Choose");
            return;
        }
        if (roomIdChoiceBox.getValue() == null) {
            roomInforLabel.setText("No Room Choose");
            return;
        }
//        LHT currentLHT = new LHT(light, humidity, temperature);
//        String currentBuildingId = buildingIdChoiceBox.getValue().toString();
//        String currentFloorId = floorIdChoiceBox.getValue().toString();
//        String currentRoomId = roomIdChoiceBox.getValue().toString();
//        Map<String, Building> buildingList = FXMLMainPadController.mainPad.getStreetRoot().getBuildingList();
//        if (buildingList.size() < 1) {
//            return;
//        }
//        Building building = buildingList.get(buildingIdChoiceBox.getValue().toString());
//        if (building == null) {
//            return;
//        }
//        Map<String, Floor> floorList = building.getFloor_list();
//        if (floorList.size() < 1) {
//            return;
//        }
//        Floor floor = floorList.get(currentFloorId);
//        if (floor == null) {
//            return;
//        }
//        if (floor.getRoomList().size() < 1) {
//            return;
//        }
//        for (String currentName : machineName_showName.keySet()) {
//            if (currentName.contains(currentBuildingId)) {
//                if (currentName.contains(currentFloorId)) {
//                    if (currentName.contains(currentRoomId)) {
//                        currentRoomId = currentName;
//                        break;
//                    }
//                }
//            }
//        }
//
//        Room currentRoom = floor.getRoomList().get(currentRoomId);
//        if (currentRoom == null) {
//            return;
//        }
//
//        try {
//            Method callback_method = this.getClass().getMethod("callback_for_machinemanagement", null);
////			System.out.println("delete machine:" + currentRoom.getRoomIdcallback_for_machinemanagement));
//            Object[] task_params = new Object[]{currentRoom, currentLHT};
//            MainPadWin.data_maintain.addRefreshTask(this, callback_method, null, DataMaintain.MODIFY_ROOM_LHT, task_params);
//            setInterInformation(modify_infor);
//        } catch (NoSuchMethodException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (SecurityException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

    }

    private List<String> getAllBuildingFromStreet(Street street) {
//        Map<String, Building> buildingList = street.getBuildingList();
//        List<String> buildingIdList = new ArrayList<String>();
//        if (buildingList.size() > 0) {
//            for (String buildingId : buildingList.keySet()) {
//                buildingIdList.add(buildingId);
//            }
//            return buildingIdList;
//        }
        return null;
    }

    private List<String> getAllMachineFromStreet(Street street) {
//        if (street.getBuildingList() == null && street.getBuildingList().size() < 1) {
//            return null;
//        }
//        Map<String, Building> buildingList = street.getBuildingList();
//        if (buildingList.size() > 0) {
////            Map<String, Floor> floorList = new HashMap<String, Floor>();
//            List<Floor> floorList = new ArrayList<Floor>();
//            for (String buildingId : buildingList.keySet()) {
//                Building currentBuilding = buildingList.get(buildingId);
//                Map<String, Floor> currentFloorList = currentBuilding.getFloor_list();
//                if (currentFloorList != null && currentFloorList.size() > 0) {
//                    for (String currentFloorId : currentFloorList.keySet()) {
//                        floorList.add(currentFloorList.get(currentFloorId));
//                    }
//                }
//            }
//
//            if (floorList.size() > 0) {
//                List<Room> roomList = new ArrayList<Room>();
//                //  Map<String, Room> currentRoomList = new HashMap<String, Room>();
//                for (Floor currentFloor : floorList) {
//                    Map<String, Room> currentRoomList = new HashMap<String, Room>();
//                    currentRoomList = currentFloor.getRoomList();
//                    if (currentRoomList != null && currentRoomList.size() > 0) {
//                        for (String currentRoomId : currentRoomList.keySet()) {
//                            roomList.add(currentRoomList.get(currentRoomId));
//                        }
//                    }
//                }
//
//                if (roomList.size() > 0) {
////                	Map<String, Machine> machineList = new HashMap<String, Machine>();
//                    Map<String, Machine> machineList = new TreeMap<String, Machine>();
//                    for (Room currentRoom : roomList) {
//                        machineList.putAll(currentRoom.getMachineList());
//                    }
//
//                    if (machineList.size() > 0) {
//                        List<String> machineNameList = new ArrayList<String>();
//                        for (String currentMachineName : machineList.keySet()) {
//                            machineNameList.add(currentMachineName);
//                        }
//                        return machineNameList;
//                    }
//                }
//            }
//        }
        return null;
    }

    @FXML
    public void unistallButtonOnAction() {
        //System.out.println("unistall button");
//        String machineName = unistallFileChoiceBox.getValue().toString();
//        //发送machineName到服务器
//        try {
//            Method task_method = this.getClass().getMethod("callback_for_machinemanagement", null);
////            System.out.println("delete machine:" + machineName);
//            Object[] callback_params = new Object[]{machineName};
//            MainPadWin.data_maintain.addRefreshTask(this, task_method, null, DataMaintain.DELETE_MACHINE, callback_params);
//            setInterInformation(unistall_infor);
//        } catch (NoSuchMethodException ex) {
//            Logger.getLogger(FXMLDeviceManagementPadController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SecurityException ex) {
//            Logger.getLogger(FXMLDeviceManagementPadController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    @FXML
    public void chooseFileButtonOnAction() {

        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("open resource file");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML", "*.xml");
            fileChooser.getExtensionFilters().add(extFilter);
            file = fileChooser.showOpenDialog(null);
            chooseFileButton.setText(file.getPath());
        } catch (Exception e) {
			// TODO Auto-generated catch block
            //	e.printStackTrace();
        }
    }

    @FXML
    public void updateFileButtonOnAction() {
//        if (file != null) {
//            ///读本地文件生成string，向网络传输
//            String gsn_xml = FileTool.read(file.getAbsolutePath());
//            try {
//                Method callback_method = this.getClass().getMethod("callback_for_machinemanagement", null);
//                int machine_name_begin_index = gsn_xml.indexOf("\"");
//                int machine_name_end_index = gsn_xml.indexOf("\"", machine_name_begin_index + 1);
//                String machine_name = gsn_xml.substring(machine_name_begin_index + 1, machine_name_end_index);
////                System.out.println("upload machine:" + machine_name);
//                Object[] task_params = new Object[]{machine_name, gsn_xml};
//                MainPadWin.data_maintain.addRefreshTask(this, callback_method, null, DataMaintain.UPLOAD_MACHINE, task_params);
//                setInterInformation(add_infor);
//            } catch (NoSuchMethodException ex) {
//                Logger.getLogger(FXMLDeviceManagementPadController.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SecurityException ex) {
//                Logger.getLogger(FXMLDeviceManagementPadController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
    }

    public void callback_for_machinemanagement() {
//        if (MainPadWin.control_refresh_data_structure) {
//            String streetMachineName = RelevantResource.prefix_address + "_" + mainPad.getStreetRoot().getStreetName();
//            try {
//                Method callback_method = this.getClass().getMethod("reflashDataStructure", null);
//                Object[] callback_params = new Object[]{};
//                Object[] task_params = new Object[]{streetMachineName};
//                MainPadWin.data_maintain.addRefreshTask(this, callback_method, callback_params, DataMaintain.BUILD_STREET_STRUCTUREE_FROM_BUILDING_TO_ROOM, task_params);
//            } catch (NoSuchMethodException ex) {
//                Logger.getLogger(FXMLMainPadController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            setInterInformation(null_infor);
//            FXMLMainPadController.closeMangerPane();
//        }
//        //     Street street = FXMLMainPadController.mainPad.getStreetRoot();
    }

    //回调
    public void reflashDataStructure() {
        ////////回调显示返回结果
//        FXMLMainPadController.mainPad.setStreetRootMonitor(true);
////        Gson gson = new Gson();
////        Street street = FXMLMainPadController.mainPad.getStreetRoot();
////        System.out.println(gson.toJson(FXMLMainPadController.mainPad.getStreetRoot()));
//        setInterInformation(null_infor);
//        FXMLMainPadController.closeMangerPane();
//
////        Platform.exit();
    }

    private void setInterInformation(int information) {
        if (information == add_infor) {
            interInformationLabel.setText("Device is being installed");
            interInformationProgressIndicator.setVisible(true);
        } else if (information == unistall_infor) {
            interInformationLabel.setText("Removing the device");
            interInformationProgressIndicator.setVisible(true);
        } else if (information == modify_infor) {
            interInformationLabel.setText("Modifying the environment");
            interInformationProgressIndicator.setVisible(true);
        } else {
            interInformationLabel.setText("");
            interInformationProgressIndicator.setVisible(false);
        }
    }
}
