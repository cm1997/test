package org.cross.elsclient.ui.util;

import java.awt.Image;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.cross.elscommon.util.UserType;

public class Images {
	static String src = "img";
	
	public static ImageIcon createImageIcon(String path){
		ImageIcon icon = new ImageIcon(path);
		return icon;
	}

	public static Image createImage(String path) {
		try {
			Image image = createImageIcon(path).getImage();
			return image;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
	public final static ImageIcon BACK_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Back.png");
	public final static ImageIcon UPDATE_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Edit.png");
	public final static ImageIcon DELETE_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Delete.png");
	public final static ImageIcon CORRECT_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Correct.png");
	public final static ImageIcon WARNING_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Warning.png");
	public final static ImageIcon LOGO_IMAGEICON = createImageIcon(src+"/Logo.png");
	public final static ImageIcon EXIT_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Close.png");
	public final static ImageIcon SETTING_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Setting.png");
	public final static ImageIcon ADD_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Add.png");
	public final static ImageIcon MINUS_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Minus.png");
	public final static ImageIcon RIGHT_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Arrow Right.png");
	public final static ImageIcon RIGHT_ACTIVE_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Arrow Right Active.png");
	public final static ImageIcon DOWN_ACTIVE_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Arrow Down.png");
	public final static ImageIcon WINDOW_MINUS_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Window Minus.png");
	public final static ImageIcon ALERT_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Alert.png");
	public final static ImageIcon EXPORT_IMAGEICON = createImageIcon(src+"/icons/Common/Icon Export.png");
	public final static ImageIcon CHECK_IMAGEICON = createImageIcon(src+"/icons/Common/Icon CheckBox.png");
	public final static ImageIcon CHECK_CHOSEN_IMAGEICON = createImageIcon(src+"/icons/Common/Icon CheckBox Chosen.png");
	
	public final static ImageIcon BG1_IMAGE = createImageIcon(src+"/Background-1.png");
	public final static ImageIcon BG2_IMAGE = createImageIcon(src+"/Background-2.png");
	public final static ImageIcon BG3_IMAGE = createImageIcon(src+"/Background-3.png");
	public final static ImageIcon BG4_IMAGE = createImageIcon(src+"/Background-4.png");
	public final static ImageIcon DIALOG_BG_IMAGE = createImageIcon(src+"/Mask.png");
	public final static ImageIcon[] BG_GROUP = {BG1_IMAGE,BG2_IMAGE,BG3_IMAGE,BG4_IMAGE};
	
	public final static ImageIcon ADMIN_AVATAR = createImageIcon(src+"/Icons/Common/Administrator.png");
	public final static ImageIcon BUSINESSCLERKCLERK_AVATAR = createImageIcon(src+"/Icons/Common/BHClerk.png");
	public final static ImageIcon COUNTER_AVATAR = createImageIcon(src+"/Icons/Common/Counter.png");
	public final static ImageIcon COURIER_AVATAR = createImageIcon(src+"/Icons/Common/Courier.png");
	public final static ImageIcon MANAGER_AVATAR = createImageIcon(src+"/Icons/Common/Manager.png");
	public final static ImageIcon TCCLERK_AVATAR = createImageIcon(src+"/Icons/Common/TCClerk.png");
	public final static ImageIcon STOCKKEEPER_AVATAR = createImageIcon(src+"/Icons/Common/Stockkeeper.png");
	
	public final static ImageIcon ADJUSTMENT_ICON = createImageIcon(src+"/icons/Nav/Icon Adjustment.png");
	public final static ImageIcon CAR_ICON = createImageIcon(src+"/icons/Nav/Icon Car.png");
	public final static ImageIcon CASH_ICON = createImageIcon(src+"/icons/Nav/Icon Cash.png");
	public final static ImageIcon CONSTANT_ICON = createImageIcon(src+"/icons/Nav/Icon Constant.png");
	public final static ImageIcon IN_ICON = createImageIcon(src+"/icons/Nav/Icon In.png");
	public final static ImageIcon INITIAL_ICON = createImageIcon(src+"/icons/Nav/Icon Initial.png");
	public final static ImageIcon LISTCHECK_ICON = createImageIcon(src+"/icons/Nav/Icon List Car.png");
	public final static ImageIcon LISTCAR_ICON = createImageIcon(src+"/icons/Nav/Icon List Check.png");
	public final static ImageIcon LISTIN_ICON = createImageIcon(src+"/icons/Nav/Icon List In.png");
	public final static ImageIcon LISTMONEY_ICON = createImageIcon(src+"/icons/Nav/Icon List Money.png");
	public final static ImageIcon LISTOUT_ICON = createImageIcon(src+"/icons/Nav/Icon List Out.png");
	public final static ImageIcon LOG_ICON = createImageIcon(src+"/icons/Nav/Icon Log.png");
	public final static ImageIcon MONEY_ICON = createImageIcon(src+"/icons/Nav/Icon Money Money.png");
	public final static ImageIcon MONEYMINUS_ICON = createImageIcon(src+"/icons/Nav/Icon Money Minus.png");
	public final static ImageIcon MONEYPLUS_ICON = createImageIcon(src+"/icons/Nav/Icon Money Plus.png");
	public final static ImageIcon MONEYSEARCH_ICON = createImageIcon(src+"/icons/Nav/Icon Money Search.png");
	public final static ImageIcon ORGANIZATION_ICON = createImageIcon(src+"/icons/Nav/Icon Organization.png");
	public final static ImageIcon OUT_ICON = createImageIcon(src+"/icons/Nav/Icon Out.png");
	public final static ImageIcon PEOPLE_ICON = createImageIcon(src+"/icons/Nav/Icon People.png");
	public final static ImageIcon SEARCH_ICON = createImageIcon(src+"/icons/Nav/Icon Search.png");
	public final static ImageIcon STATISTICS_ICON = createImageIcon(src+"/icons/Nav/Icon Statistics.png");
	public final static ImageIcon STOCK_ICON = createImageIcon(src+"/icons/Nav/Icon Stock.png");
	public final static ImageIcon LIST_ICON = createImageIcon(src+"/icons/Nav/Icon List.png");
	
	public final static ImageIcon ADJUSTMENT_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Adjustment Active.png");
	public final static ImageIcon CAR_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Car Active.png");
	public final static ImageIcon CASH_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Cash Active.png");
	public final static ImageIcon CONSTANT_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Constant Active.png");
	public final static ImageIcon IN_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon In Active.png");
	public final static ImageIcon INITIAL_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Initial Active.png");
	public final static ImageIcon LISTCHECK_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon List Car Active.png");
	public final static ImageIcon LISTCAR_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon List Check Active.png");
	public final static ImageIcon LISTIN_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon List In Active.png");
	public final static ImageIcon LISTMONEY_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon List Money Active.png");
	public final static ImageIcon LISTOUT_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon List Out Active.png");
	public final static ImageIcon LOG_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Log Active.png");
	public final static ImageIcon MONEY_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Money Money Active.png");
	public final static ImageIcon MONEYMINUS_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Money Minus Active.png");
	public final static ImageIcon MONEYPLUS_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Money Plus Active.png");
	public final static ImageIcon MONEYSEARCH_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Money Search Active.png");
	public final static ImageIcon ORGANIZATION_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Organization Active.png");
	public final static ImageIcon OUT_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Out Active.png");
	public final static ImageIcon PEOPLE_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon People Active.png");
	public final static ImageIcon SEARCH_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Search Active.png");
	public final static ImageIcon STATISTICS_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Statistics Active.png");
	public final static ImageIcon STOCK_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon Stock Active.png");
	public final static ImageIcon LIST_ACTIVE_ICON = createImageIcon(src+"/icons/Nav Active/Icon List Active.png");
	
	public static ImageIcon getImageIcon(String name){
		switch (name) {
		case "back":
			return BACK_IMAGEICON;
		case "update":
			return UPDATE_IMAGEICON;
		case "delete":
			return DELETE_IMAGEICON;
		case "stockadjust":
			return ADJUSTMENT_ICON;
		case "vehicle":
			return CAR_ICON;
		case "payment":
			return CASH_ICON;
		case "constant":
			return CONSTANT_ICON;
		case "receive":
			return IN_ICON;
		case "expressSend":
			return OUT_ICON;
		case "initial":
			return INITIAL_ICON;
		case "receiptApproval":
			return LISTCHECK_ICON;
		case "trans":
			return LISTCAR_ICON;
		case "arrive":
		case "stockin":
			return LISTIN_ICON;
		case "send":
		case "stockout":
			return LISTOUT_ICON;
		case "moneyin":
			return LISTMONEY_ICON;
		case "log":
			return LOG_ICON;
		case "account":
			return MONEY_ICON;
		case "accountCheck":
			return MONEYSEARCH_ICON;
		case "cost":
			return MONEYMINUS_ICON;
		case "settle":
			return MONEYPLUS_ICON;
		case "organization":
			return ORGANIZATION_ICON;
		case "stocksee":
		case "goodsCheck":
			return SEARCH_ICON;
		case "analysis":
			return STATISTICS_ICON;
		case "stockcheck":
			return STOCK_ICON;
		case "personnel":
		case "user":
		case "driver":
			return PEOPLE_ICON;
		case "receipts":
			return LIST_ICON;
		default:
			return null;
		}
	}
	
	public static ImageIcon getAvatar(UserType type){
		switch (type) {
		case ADMINISTRATOR:
			return ADMIN_AVATAR;
		case COUNTER:
		case SUPERCOUNTER:
			return COUNTER_AVATAR;
		case COURIER:
			return COURIER_AVATAR;
		case BUSINESSHALLCLERK:
			return BUSINESSCLERKCLERK_AVATAR;
		case MANAGER:
			return MANAGER_AVATAR;
		case STOCKKEEPER:
			return STOCKKEEPER_AVATAR;
		case TRANSITCENTERCLERK:
			return TCCLERK_AVATAR;
		default:
			return null;
		}
	}
	
	public static ImageIcon getActiveIcon(String name){
		switch (name) {
		case "stockadjust":
			return ADJUSTMENT_ACTIVE_ICON;
		case "vehicle":
			return CAR_ACTIVE_ICON;
		case "payment":
			return CASH_ACTIVE_ICON;
		case "constant":
			return CONSTANT_ACTIVE_ICON;
		case "receive":
			return IN_ACTIVE_ICON;
		case "expressSend":
			return OUT_ACTIVE_ICON;
		case "initial":
			return INITIAL_ACTIVE_ICON;
		case "receiptApproval":
			return LISTCHECK_ACTIVE_ICON;
		case "trans":
			return LISTCAR_ACTIVE_ICON;
		case "arrive":
		case "stockin":
			return LISTIN_ACTIVE_ICON;
		case "send":
		case "stockout":
			return LISTOUT_ACTIVE_ICON;
		case "moneyin":
			return LISTMONEY_ACTIVE_ICON;
		case "log":
			return LOG_ACTIVE_ICON;
		case "account":
			return MONEY_ACTIVE_ICON;
		case "accountCheck":
			return MONEYSEARCH_ACTIVE_ICON;
		case "cost":
			return MONEYMINUS_ACTIVE_ICON;
		case "settle":
			return MONEYPLUS_ACTIVE_ICON;
		case "organization":
			return ORGANIZATION_ACTIVE_ICON;
		case "stocksee":
		case "goodsCheck":
			return SEARCH_ACTIVE_ICON;
		case "analysis":
			return STATISTICS_ACTIVE_ICON;
		case "stockcheck":
			return STOCK_ACTIVE_ICON;
		case "personnel":
		case "user":
		case "driver":
			return PEOPLE_ACTIVE_ICON;
		case "receipts":
			return LIST_ACTIVE_ICON;
		default:
			return null;
		}
	}
	
}
