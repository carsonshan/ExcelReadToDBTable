package excelToTable.rest.services.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.monitorjbl.xlsx.StreamingReader;
import excelToTable.rest.services.model.RBPEmployees;
import excelToTable.rest.services.model.RBPGroups;
import excelToTable.rest.services.service.RBPEmployeesService;
import excelToTable.rest.services.service.RBPGroupsService;



@RestController
public class UploadExcelToTableController {
	Logger logger = LoggerFactory.getLogger(UploadExcelToTableController.class);
	 @Autowired
	 RBPEmployeesService RBPEmployeesService;
	 @Autowired
	 RBPGroupsService RBPGroupsService;
	 
	 @PostMapping("/excelUpload")
	 public ResponseEntity<?> upload(@RequestParam("file") MultipartFile uploadfile) throws IOException{
		 
		
		 RBPGroupsService.updateAll();
		 RBPEmployeesService.updateAll(); 
		 
		 InputStream excelFile = new ByteArrayInputStream(uploadfile.getBytes());
		 Workbook workbook = StreamingReader.builder()
			        .rowCacheSize(16384)    // number of rows to keep in memory (defaults to 10)
			        .bufferSize(8192)     // buffer size to use when reading InputStream to file (defaults to 1024)
			        .open(excelFile); 
		 RBPEmployees employee;
		 RBPGroups group;
		 
         int index;
		Sheet sheetGroups = workbook.getSheet("Groups");
		Sheet sheetEmployees = workbook.getSheet("Employees");
			
			  for (Row rGroup : sheetGroups) {
				  group = new RBPGroups();
	                index = 0;
			    for (Cell currentCellGroup : rGroup) {
					    	if ( index == 0)
					    	 {
					    		group.setUserId(currentCellGroup.getStringCellValue());
			                 }
						    else if (index == 1)
			               	 {
			               		 group.setRole(currentCellGroup.getStringCellValue());
			               	 }
	                    	else if (index == 2)
	                    	 {
	                    		 group.setGrp(currentCellGroup.getStringCellValue());
	                    	 }
	                    		                    	 
			    	index = index +1;
			    }
			    group.setFlag(0);
			    RBPGroupsService.create(group);
			  }	
			  
			  for (Row rEmployee : sheetEmployees) {
				  employee = new RBPEmployees();
	                index = 0;
			    for (Cell currentCellEmployee : rEmployee) {
					    	if ( index == 0)
					    	 {
					    		employee.setUserId(currentCellEmployee.getStringCellValue());
			                 }
	                    	else if (index == 1)
	                    	 {
	                    		employee.setGrp(currentCellEmployee.getStringCellValue());
	                    	 }
	                    		                    	 
			    	index = index +1;
			    }
			    employee.setFlag(0);
			    RBPEmployeesService.create(employee);
			  }
			  RBPEmployeesService.deleteFlagged();
			  RBPGroupsService.deleteFlagged();
			  
		return ResponseEntity.ok().body("success");
	 }

}
