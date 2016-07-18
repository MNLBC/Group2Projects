 CREATE TABLE "ADMIN"."STUDENT" 
   (	"STUDENT_ID" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
	"STUDENT_NAME" VARCHAR2(100 BYTE), 
	"STUDENT_SCORE" NUMBER, 
	"STUDENT_TEACHERID" VARCHAR2(100 BYTE), 
	 CONSTRAINT "STUDENT_PK" PRIMARY KEY ("STUDENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE, 
	 CONSTRAINT "STUDENT_TEACHERID_FK" FOREIGN KEY ("STUDENT_TEACHERID")
	  REFERENCES "ADMIN"."TEACHER" ("TEACHER_ID") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
