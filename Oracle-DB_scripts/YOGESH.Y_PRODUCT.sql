--DDL

DROP TABLE IF EXISTS YOGESH.Y_PRODUCT;
/

  CREATE TABLE YOGESH.Y_PRODUCT 
   (	
	ID VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	CODE VARCHAR2(20 BYTE), 
	NAME VARCHAR2(20 BYTE), 
	POINTS NUMBER, 
	 CONSTRAINT Y_PRODUCT_PK PRIMARY KEY (ID)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 81920 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE DATA  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 81920 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE DATA ;

/
GRANT ALTER, SELECT ,UPDATE ,INSERT , DELETE  ON YOGESH.Y_PRODUCT TO PUBLIC;
/

CREATE SEQUENCE  YOGESH.Y_Y_PRODUCT_ID_SEQ  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
GRANT SELECT ON YOGESH.Y_Y_PRODUCT_ID_SEQ TO PUBLIC;
/
--DML
Insert into YOGESH.Y_PRODUCT (ID,CODE,NAME,POINTS) values (YOGESH.Y_Y_PRODUCT_ID_SEQ.nextval,'P1','BMW',10);
Insert into YOGESH.Y_PRODUCT (ID,CODE,NAME,POINTS) values (YOGESH.Y_Y_PRODUCT_ID_SEQ.nextval,'P2','Benz',20);
Insert into YOGESH.Y_PRODUCT (ID,CODE,NAME,POINTS) values (YOGESH.Y_Y_PRODUCT_ID_SEQ.nextval,'P3','Maruti Suzuki Baleno',30);
Insert into YOGESH.Y_PRODUCT (ID,CODE,NAME,POINTS) values (YOGESH.Y_Y_PRODUCT_ID_SEQ.nextval,'P4','Hyundai Elite i20',40);
Insert into YOGESH.Y_PRODUCT (ID,CODE,NAME,POINTS) values (YOGESH.Y_Y_PRODUCT_ID_SEQ.nextval,'P5','Land Rover',50);
commit;
/