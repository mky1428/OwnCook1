package com.mky1428.owncook1;

public class RecyclerItem {

    String ATT_FILE_NO_MAIN;
    String RCP_NM;
    String RCP_PARTS_DTLS;
    String MANUAL;

    public RecyclerItem() {
    }

    public RecyclerItem(String ATT_FILE_NO_MAIN, String RCP_NM, String RCP_PARTS_DTLS, String MANUAL) {
        this.ATT_FILE_NO_MAIN = ATT_FILE_NO_MAIN;
        this.RCP_NM = RCP_NM;
        this.RCP_PARTS_DTLS = RCP_PARTS_DTLS;
        this.MANUAL = MANUAL;
    }
}
