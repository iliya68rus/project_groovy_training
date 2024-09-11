import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class XlsxBuilder {
    static XlsxSpecification xlsx;

    static void xlsxBuilder(String fileName, @DelegatesTo(XlsxSpecification) Closure closure) {
        def specification = new XlsxSpecification()
        xlsx = specification
        specification.fileName = fileName
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()

        creatDocument()
        println "Документ создан"
    }

    static void creatDocument() {
        Workbook workbook = new XSSFWorkbook()

        int idxSheet = 0
        for (final SheetSpecification sheetSp in xlsx.sheets) {
            def name = sheetSp.name
            if (name == null) {
                name = idxSheet
            }
            Sheet sheet = workbook.createSheet(name as String)

            for (final RowSpecification rowSp in sheetSp.rows) {
                Row row = sheet.createRow(rowSp.number)
                int idxCell = 0
                for (final CellSpecification cellSp in rowSp.cells) {
                    def idxCellSp = cellSp.idx
                    if (idxCellSp == null) {
                        idxCellSp = idxCell
                    }
                    Cell cell = row.createCell(idxCellSp)
                    cell.setCellValue(cellSp.value as String)
                    idxCell++;
                }
            }
            idxSheet++
        }

        def fileName = xlsx.fileName;
        if (!fileName.contains(".")) {
            fileName += ".xlsx"
        }
        workbook.write(new FileOutputStream(fileName))
    }
}

