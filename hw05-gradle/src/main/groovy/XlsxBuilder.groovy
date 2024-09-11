class XlsxBuilder {
    static XlsxSpecification xlsx;

    static void xlsxBuilder(String fileName, @DelegatesTo(XlsxSpecification) Closure closure) {
        def specification = new XlsxSpecification()
        xlsx = specification
        specification.fileName = fileName
        closure.delegate = specification
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure()

//        creatDocument()
        println "Документ создан"
    }

//    static void creatDocument() {
//        Workbook workbook = new XSSFWorkbook()
//
//        int idx = 0;
//        for (final SheetSpecification sheetSp in sheets) {
//            def name = sheetSp.name
//            if (name == null) {
//                name = idx
//            }
//            Sheet sheet = workbook.createSheet(name as String)
//
//            for (final RowSpecification rowSp in sheetSp.rows) {
//                Row row = sheet.createRow(rowSp.number)
//                for (final CellSpecification cellSp in rowSp.cells) {
////                    cellSp.values
////                    Cell cell = row.createCell(cellSp.)
////                    cell.setCellValue("Значение для ячейки A1")
//                }
//            }
//            idx++
//        }
//
//
//        if (!fileName.contains(".")) {
//            fileName += ".xlsx"
//        }
//        workbook.write(new FileOutputStream(fileName))
//    }
}

