--------------------------------------------------------
--  File created - Friday-June-24-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CHAT_MESSAGE
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."CHAT_MESSAGE" 
   (	"MESSAGE_ID" NUMBER(9,0), 
	"MESSAGE_SENDER" VARCHAR2(50 BYTE), 
	"MESSAGE" VARCHAR2(1000 BYTE), 
	"SESSION_ID" NUMBER(3,0), 
	"MESSAGE_DT" VARCHAR2(50 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index CHAT_MESSAGE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."CHAT_MESSAGE_PK" ON "SYSTEM"."CHAT_MESSAGE" ("MESSAGE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table CHAT_MESSAGE
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."CHAT_MESSAGE" ADD CONSTRAINT "CHAT_MESSAGE_PK" PRIMARY KEY ("MESSAGE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SYSTEM"."CHAT_MESSAGE" MODIFY ("MESSAGE_DT" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."CHAT_MESSAGE" MODIFY ("SESSION_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."CHAT_MESSAGE" MODIFY ("MESSAGE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  DDL for Trigger CHAT_MESSAGE_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "SYSTEM"."CHAT_MESSAGE_TRG" 
BEFORE INSERT ON CHAT_MESSAGE 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.MESSAGE_ID IS NULL THEN
      SELECT CHAT_MESSAGE_SEQ.NEXTVAL INTO :NEW.MESSAGE_ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "SYSTEM"."CHAT_MESSAGE_TRG" ENABLE;
