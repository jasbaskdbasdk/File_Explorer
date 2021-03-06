package com.yang.file_explorer.utils;

import android.content.Intent;
import android.widget.Toast;

import com.actionbarsherlock.view.Menu;

import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuItem.OnMenuItemClickListener;
import com.actionbarsherlock.view.SubMenu;
import com.yang.file_explorer.R;
import com.yang.file_explorer.ui.MainActivity;
import com.yang.file_explorer.ui.SearchActivity;

public class MenuUtils implements OnMenuItemClickListener {

	public enum MenuItemType {
		MENU_DEVICE, MENU_FAVORITE, MENU_WIFI, MENU_MUSIC, MENU_IMAGE, MENU_VIDEO, MENU_DOCUMENT, MENU_ZIP, MENU_APK
	}

	private static MenuUtils mmenuMenuUtils = null;

	// 创建实例
	private MenuUtils() {
	}

	public static MenuUtils getInstance() {
		if (mmenuMenuUtils == null) {
			mmenuMenuUtils = new MenuUtils();
		}

		return mmenuMenuUtils;
	}

	public boolean addMenu(Menu menu) {

		// 排序菜单
		SubMenu subMenu = menu.addSubMenu(0, 1, 0, R.string.menu_item_sort)
				.setIcon(R.drawable.ic_sort_actionbar);
		subMenu.getItem().setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

		addMenu(subMenu, 11, 0, R.string.menu_item_sort_date);
		addMenu(subMenu, 12, 1, R.string.menu_item_sort_name);
		addMenu(subMenu, 13, 2, R.string.menu_item_sort_size);
		addMenu(subMenu, 14, 3, R.string.menu_item_sort_type);
		subMenu.setGroupCheckable(0, true, true);
		subMenu.getItem(0).setChecked(true);

		// 新建菜单
		addMenu(menu, 2, 1, R.string.new_folder_name,
				R.drawable.ic_create_actionbar);

		// 搜索菜单
		addMenu(menu, 3, 2, R.string.search, R.drawable.ic_search_actionbar);
		// 刷新菜单
		addMenu(menu, 4, 3, R.string.refresh, R.drawable.ic_refresh_actionbar);
		// 设置菜单
		addMenu(menu, 5, 4, R.string.setting);
		// 关于菜单
		addMenu(menu, 6, 5, R.string.about);
		// 退出
		addMenu(menu, 7, 6, R.string.exit);
		return true;
	}

	public void addMenu(Menu menu, int itemId, int order, int titleRes) {
		addMenu(menu, itemId, order, titleRes, -1);
	}

	public void addMenu(Menu menu, int itemId, int order, int titleRes, int icon) {

		MenuItem menuItem = menu.add(0, itemId, order, titleRes)
				.setOnMenuItemClickListener(this);
		if (icon > 0) {
			menuItem.setIcon(icon);
		}

		if (itemId != 2 && itemId != 3 && itemId != 4) {
			menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
		} else {
			menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		}

	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case 11: // 时间排序
			ToastUtils.getInstance().showMask("时间排序", Toast.LENGTH_LONG);
			break;
		case 12: // 名字排序
			ToastUtils.getInstance().showMask("名字排序", Toast.LENGTH_LONG);
			break;
		case 13: // 大小排序
			break;
		case 14: // 类型排序
			break;
		case 2: // 新建
			ToastUtils.getInstance().showMask("新建", Toast.LENGTH_LONG);
			break;
		case 3: // 搜索
			Intent intent = new Intent(MainActivity.getActivity(),
					SearchActivity.class);
			MainActivity.getActivity().startActivity(intent);
			break;
		case 4: // 刷新
			ToastUtils.getInstance().showMask("刷新", Toast.LENGTH_LONG);
			break;
		case 5: // 设置

			break;

		case 6: // 关于
			ToastUtils.getInstance().showMask("关于", Toast.LENGTH_LONG);
			break;

		case 7: // 退出
			break;

		default:
			break;
		}
		return true;
	}
}
