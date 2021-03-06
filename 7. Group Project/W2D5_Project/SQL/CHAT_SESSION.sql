--------------------------------------------------------
--  File created - Saturday-June-25-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CHAT_SESSION
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."CHAT_SESSION" 
   (	"SESSION_ID" NUMBER(3,0), 
	"START_DT" VARCHAR2(50 BYTE), 
	"END_DT" VARCHAR2(50 BYTE), 
	"ACTIVE" NUMBER(1,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index CHAT_SESSION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."CHAT_SESSION_PK" ON "SYSTEM"."CHAT_SESSION" ("SESSION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table CHAT_SESSION
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."CHAT_SESSION" MODIFY ("SESSION_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."CHAT_SESSION" MODIFY ("START_DT" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."CHAT_SESSION" ADD CONSTRAINT "CHAT_SESSION_PK" PRIMARY KEY ("SESSION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  DDL for Trigger CHAT_SESSION_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYSTEM"."CHAT_SESSION_TRG1" 
BEFORE INSERT ON CHAT_SESSION 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.SESSION_ID IS NULL THEN
      SELECT CHAT_SESSION_SEQ.NEXTVAL INTO :NEW.SESSION_ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "SYSTEM"."CHAT_SESSION_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger CHAT_SESSION_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYSTEM"."CHAT_SESSION_TRG" 
BEFORE INSERT ON CHAT_SESSION 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "SYSTEM"."CHAT_SESSION_TRG" ENABLE;
