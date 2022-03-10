ALTER TABLE `tv`.`user` 
ADD UNIQUE INDEX `unique_tel`(`utel`(15)) USING BTREE,
ADD UNIQUE INDEX `unique_id`(`uid`) USING BTREE;

ALTER TABLE `tv`.`tv_room` 
ADD UNIQUE INDEX `unique_tvrid`(`tvrid`) USING BTREE;

ALTER TABLE `tv`.`dispatch_list` 
ADD UNIQUE INDEX `unique_did`(`did`) USING BTREE;

ALTER TABLE `tv`.`dispatch_audit` 
ADD UNIQUE INDEX `unique_dlaid`(`dlaid`) USING BTREE;

ALTER TABLE `tv`.`column` 
ADD UNIQUE INDEX `unique_cid`(`cid`) USING BTREE;

ALTER TABLE `tv`.`advertisement` 
ADD UNIQUE INDEX `unique_aid`(`aid`) USING BTREE;

ALTER TABLE `tv`.`ad_dispatch` 
ADD UNIQUE INDEX `unique_adid`(`adid`) USING BTREE;