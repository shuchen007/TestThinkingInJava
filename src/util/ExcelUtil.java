package util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/7.
 */
public class ExcelUtil {
    static HSSFSheet sheet1;
    static String[] dataRows;
    static int[] rowRecord;

    /**
     * 设置表中单元格格式
     * @param hssfWorkBook
     * @return
     */
    private Map<String,CellStyle> setCellStyle(HSSFWorkbook hssfWorkBook){
        Map<String,CellStyle>map=new HashMap();
        CellStyle datetimeCellStyle = hssfWorkBook.createCellStyle();  //日期单元格格式
        HSSFDataFormat format = hssfWorkBook.createDataFormat();
        datetimeCellStyle.setDataFormat(format.getFormat("yyyy-MM-dd")) ;
        datetimeCellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        datetimeCellStyle.setBorderLeft(CellStyle.BORDER_THIN); ;
        datetimeCellStyle.setBorderRight(CellStyle.BORDER_THIN);
        datetimeCellStyle.setBorderTop(CellStyle.BORDER_THIN);
        datetimeCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        datetimeCellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        datetimeCellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        datetimeCellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        datetimeCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        datetimeCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        datetimeCellStyle.setWrapText(true);

        CellStyle titleStyle = hssfWorkBook.createCellStyle();   // 表头格式
        titleStyle.setBorderBottom(CellStyle.BORDER_THIN);
        HSSFFont boldFont = hssfWorkBook.createFont();
        boldFont.setFontHeightInPoints((short) 12);
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        titleStyle.setFont(boldFont);
        titleStyle.setBorderBottom(CellStyle.BORDER_THIN);
        titleStyle.setBorderLeft(CellStyle.BORDER_THIN);
        titleStyle.setBorderRight(CellStyle.BORDER_THIN);
        titleStyle.setBorderTop(CellStyle.BORDER_THIN);
        titleStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        titleStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        titleStyle.setRightBorderColor(HSSFColor.BLACK.index);
        titleStyle.setTopBorderColor(HSSFColor.BLACK.index);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        titleStyle.setWrapText(true);// 自动换行

        CellStyle IntroductionsStyle = hssfWorkBook.createCellStyle();   // 说明格式
        // IntroductionsStyle.setBorderBottom(CellStyle.BORDER_THIN);
        HSSFFont introboldFont = hssfWorkBook.createFont();
        introboldFont.setFontHeightInPoints((short) 12);
        introboldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        introboldFont.setFontName("宋体");
        introboldFont.setColor(HSSFColor.RED.index); //红色字体
        IntroductionsStyle.setFont(introboldFont);
        IntroductionsStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);; //左对齐
        IntroductionsStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        CellStyle cellStyle = hssfWorkBook.createCellStyle();  // 普通单元格格式
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setWrapText(true); // 自动换行
        map.put("date", datetimeCellStyle);
        map.put("title", titleStyle);
        map.put("introductions",IntroductionsStyle);
        map.put("cell",cellStyle);
        return map;
    }

    /**
     * 导出表格
     *
     * @param columnField  表名@列名|所占行|所占列|宽度|@复合列名|所占行|所占列|宽度……
     * @param rowData      表中数据，每行之间用@隔开，单元格之间用|隔开
     * @param mergeColunms 合并列，从0开始
     * @return
     */
    public static String ExportExcel(String columnField, String rowData, String remarks, String mergeColunms) {
        // InitializeWorkbook();
        HSSFWorkbook hssfWorkBook = new HSSFWorkbook();
        sheet1 = hssfWorkBook.createSheet("sheet1");
        dataRows = columnField.split("@"); // 表名表头数据
        rowRecord = new int[dataRows.length]; // 表名表头数据长度
        if (columnField == "")
            return "";
        else {
            String[] strDatas = rowData.split("@"); // 表中数据
            int num=1;
            String[] columnsData = dataRows[num].split("\\|");   // 表头数据
            int countColumn = 0;
            int countTitleRow = 0;
            countTitleRow = dataRows.length + 1; // 表名和表头所占的总行数
            HSSFCellStyle cellStyle = hssfWorkBook.createCellStyle();
            cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyle.setBorderRight(CellStyle.BORDER_THIN);
            cellStyle.setBorderTop(CellStyle.BORDER_THIN);
            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
            cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
            cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            cellStyle.setWrapText(true); // 自动换行

            HSSFCellStyle titleCellStyle = hssfWorkBook.createCellStyle();
            HSSFFont boldFont = hssfWorkBook.createFont();
            boldFont.setFontHeightInPoints((short) 18);
            boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
            titleCellStyle.setFont(boldFont);
            titleCellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            titleCellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            titleCellStyle.setBorderRight(CellStyle.BORDER_THIN);
            titleCellStyle.setBorderTop(CellStyle.BORDER_THIN);
            titleCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
            titleCellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
            titleCellStyle.setRightBorderColor(HSSFColor.BLACK.index);
            titleCellStyle.setTopBorderColor(HSSFColor.BLACK.index);
            titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            titleCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            titleCellStyle.setWrapText(true);

            for (int i = 0; i < columnsData.length; i += 4) {
                countColumn += Integer.parseInt(columnsData[i + 2]); //获取表头所占列数
            }
            for (int i = 0; i < countTitleRow + strDatas.length; i++) {
                HSSFRow row = sheet1.createRow(i);
                for (int j = 0; j < countColumn; j++) { //表头所占列数
                    HSSFCell cell = row.createCell(j);
                    if (i == 0 && j == 0) {
                        cell.setCellValue(dataRows[0]); //dataRows[0].Substring(0, dataRows[0].IndexOf('-'))
                        cell.setCellStyle(titleCellStyle);
                    } else {
                        cell.setCellStyle(cellStyle);
                    }
                }
            }
            CellRangeAddress regionTitle = new CellRangeAddress(0, 1, 0, countColumn - 1); // 表头占两行
            sheet1.addMergedRegion(regionTitle);
            HSSFRow row0 = sheet1.getRow(2);//从第二行开始填充表头
            int columnIndex = 0;
            int nextRow = 0;
            int rowMerge = 1;
            int columnMerge = 1;
            for (int j = 0; j < columnsData.length; j += 4) {   // columnsData表头数据
                HSSFCell cell0 = row0.getCell(columnIndex); //columnIndex当前行的指定列，默认第一个为0列，往后依次累加字段所占列数
                cell0.setCellValue(columnsData[j]);
                columnMerge = Integer.parseInt(columnsData[j + 2]);//columnMerge当前字段所占列数
                rowMerge = Integer.parseInt(columnsData[j + 1]); //rowMerge当前字段所占行数
                if (columnMerge > 1 || (rowMerge < countTitleRow - 2)) { // countTitleRow表名和表头所占的总行数，其中表名占2行
                    nextRow = 2 + rowMerge; // 当前行的下一行
                    //dataRows[2] 当前表头数据的下一行数据,   rowRecord表名表头数据长度的数组
                    setColDataRow(dataRows[2].split("\\|"), rowRecord[2], columnMerge, 2, nextRow, columnIndex);
                    rowRecord[2] += Integer.parseInt(columnsData[j + 2]);
                    for (int k = 0; k < columnMerge; k++) {
                        if (columnsData[j + 3] != "undefined") {
                            int wid = Integer.parseInt(columnsData[j + 3]) * 32;
                            if (wid > '\uff00') {
                                wid = '\uff00';
                            }
                            sheet1.setColumnWidth(columnIndex + k, wid);
                        }
                    }
                    CellRangeAddress region = new CellRangeAddress(2,1+rowMerge, columnIndex, columnIndex + columnMerge - 1);
                    sheet1.addMergedRegion(region);
                    columnIndex += Integer.parseInt(columnsData[j + 2]); //依次累加字段所占列数
                } else {
                    if (columnsData[j + 3] != "undefined") {
                        int wid = Integer.parseInt(columnsData[j + 3]) * 32;
                        if (wid > '\uff00') {
                            wid = '\uff00';
                        }
                        sheet1.setColumnWidth(columnIndex, wid);
                    }
                    if (rowMerge > 1 || columnMerge > 1) { //rowMerge当前字段所占行数，columnMerge当前字段所占列数
                        CellRangeAddress region = new CellRangeAddress(2, 1+ rowMerge, columnIndex, columnIndex + columnMerge - 1);
                        sheet1.addMergedRegion(region);
                    }
                    columnIndex++;
                }
            }
            String[] merge = mergeColunms != null && !mergeColunms.equals("") ? mergeColunms.split(",") : new String[]{}; // 获取指定的合并列
            int n = merge.length;
            int[] start = new int[n]; //记录同组开始行号
            int[] end = new int[n]; //记录同组结束行号
            String[] temp = new String[n];
            for (int i = countTitleRow; i < countTitleRow + strDatas.length; i++)  // 表中数据
            {
                HSSFRow row = sheet1.getRow(i); // 生成表格中的行
                String[] data = strDatas[i - countTitleRow].split("\\|"); // 相当于获取dt中第i行的列值
                for (int j = 0; j < data.length; j++) {
                    HSSFCell cell = row.getCell(j);
                    if (cell == null) {
                        cell = row.createCell(j);
                        cell.setCellStyle(cellStyle);
                    }
                    String cellText = data[j];
                    cell.setCellValue(cellText);
                    for (int k = 0; k < merge.length; k++) // 获取指定的合并列
                    {
                        if (merge[k] != null && merge[k] != "") {
                            if (j == Integer.parseInt(merge[k])) {
                                if (cellText.equals(temp[k]))//上下行相等，记录要合并的最后一行
                                {
                                    if (k - 1 >= 0 && start[k - 1] > start[k]) // 当前一列已经合并，当前列还没合并但上下行值相等时，强制合并当前列
                                    {
                                        CellRangeAddress region = new CellRangeAddress(start[k], end[k], j, j);
                                        sheet1.addMergedRegion(region);
                                        start[k] = i;
                                    }
                                    end[k] = i;
                                    if (i == countTitleRow + strDatas.length - 1) // 到达最后一列时，上下行相等，强制合并
                                    {
                                        CellRangeAddress region = new CellRangeAddress(start[k], end[k], j, j);
                                        sheet1.addMergedRegion(region);
                                    }
                                } else //上下行不等，记录
                                {
                                    if (start[k] != end[k]) {
                                        CellRangeAddress region = new CellRangeAddress(start[k], end[k], j, j);
                                        sheet1.addMergedRegion(region);
                                    }
                                    start[k] = i;
                                    end[k] = i;
                                    temp[k] = cellText;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (remarks != null && !"".equals(remarks)) {

            int rowNum = sheet1.getLastRowNum();
            int cellNum = sheet1.getRow(rowNum - 1).getPhysicalNumberOfCells();

            HSSFRow lastrow = sheet1.createRow(rowNum + 1);
            HSSFCell cell = lastrow.createCell(0);
            HSSFCellStyle cellStyle = hssfWorkBook.createCellStyle();
            cell.setCellStyle(cellStyle);
            cellStyle.setWrapText(true);
//            cell.setCellStyle(cellStyle);
            cell.setCellValue(remarks);

//            new String(remarks.getBytes("ISO-8859-1"), "UTF-8");
//            new String(remarks.getBytes("ISO-8859-1"), "ISO-8859-1");
            CellRangeAddress cra = new CellRangeAddress(rowNum + 1, rowNum + 3, 0, cellNum - 1);
            sheet1.addMergedRegion(cra);
        }

        String fileName = "";
        try {
            UUID uuid = UUID.randomUUID();
            fileName = uuid.toString();
            String pt = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").lastIndexOf(File.separator)) + File.separator + "webapps" + File.separator + "jsvc" + File.separator + "WEB-INF" + File.separator + "classes" + File.separator + "TempFile";
            File file = new File(pt);
            if (!file.exists() && !file.isDirectory()) {
                // file.createNewFile();
                file.mkdirs();
            }
            FileOutputStream out1 = new FileOutputStream(pt + File.separator + fileName + ".xls");
            hssfWorkBook.write(out1);
            out1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    /**
     * 合并列时，先设置下一行数据
     * @param columnData 下一行数据
     * @param start 开始列
     * @param colCount 所占列总数
     * @param dataRow 当前表头数据行
     * @param currentRow 当前行
     * @param currentColumn 当前列
     */
    private static void setColDataRow(String[] columnData, int start, int colCount, int dataRow, int currentRow, int currentColumn) {
        HSSFRow row0 = sheet1.getRow(currentRow);
        int columnIndex = 0;
        int nextRow = 0;
        int rowMerge = 1;
        int columnMerge = 1;
        int dataColumnIndex = 0;
        for (int k = 0; k < colCount; k++) {
            columnIndex = currentColumn; //当前列
            dataColumnIndex = (start + k) * 4;
            HSSFCell cell0 = row0.getCell(columnIndex);
            System.out.println(columnData);
            System.out.println(dataColumnIndex);
            cell0.setCellValue(columnData[dataColumnIndex]);
            rowMerge = Integer.parseInt(columnData[dataColumnIndex + 1]);
            columnMerge = Integer.parseInt(columnData[dataColumnIndex + 2]);
            if (columnData[dataColumnIndex + 3] != "undefined") {
                int wid = Integer.parseInt(columnData[dataColumnIndex + 3]) * 32;
                if (wid > '\uff00') {
                    wid = '\uff00';
                }
                sheet1.setColumnWidth(columnIndex, wid);
//                sheet1.setColumnWidth(columnIndex, Integer.parseInt(columnData[dataColumnIndex + 3]) * 32);
            }
            if (columnMerge > 1 || rowMerge > dataRows.length - currentRow + 1) {
                //nextRow = currentRow + rowMerge;
                //递归
                setColDataRow(dataRows[dataRow + 1].split("\\|"), rowRecord[dataRow+1], columnMerge, dataRow + 1, currentRow + rowMerge, columnIndex);
                //rowRecord[dataRow - 1] -= columnMerge - 1;
                rowRecord[dataRow] += columnMerge;
                colCount -= columnMerge - 1;
            }
            if (rowMerge > 1 || columnMerge > 1) {
                CellRangeAddress region = new CellRangeAddress(currentRow, currentRow+rowMerge-1,columnIndex, columnIndex + columnMerge-1);
                sheet1.addMergedRegion(region);
            }
            currentColumn += columnMerge;
        }
    }

    public static void main(String args[]){
//
//         columnField = "输差分析多级表头title@日期|3|1|50|商品率|1|3|150|单井-集气站输差分析|1|4|200@井口气|2|1|50|商品量|2|1|50|商品率|2|1|50|龙王庙集气总站|1|2|100|西眉清管站|1|2|100@绝对输差|1|1|50|相对输差|1|1|50|绝对输差|1|1|50|相对输差|1|1|50";
        String columnField = "输差分析多级表头title@商品率|1|3|150|单井-集气站输差分析|1|4|200@井口气|2|1|50|商品量|2|1|50|商品率|2|1|50|龙王庙集气总站|1|2|100|西眉清管站|1|2|100@绝对输差|1|1|50|相对输差|1|1|50|绝对输差|1|1|50|相对输差|1|1|50";
         String rowData = "44|23|fds|23@44|23|efw|fes|df@fs|23";
        String s = ExportExcel(columnField,rowData , "ff", "1");


        System.out.println("s=" + s);
        System.out.println(System.getProperty("user.dir")+System.getProperty("path.separator")+System.getProperty("user.name"));
        System.out.println(System.getProperty("user.dir").substring(0, System.getProperty("user.dir").lastIndexOf(File.separator)));
        System.out.println(System.getProperty("file.separator")+File.separator);
    }
}
