package org.zstack.core.trash;

import org.zstack.core.jsonlabel.JsonLabelInventory;
import org.zstack.header.storage.backup.StorageTrashSpec;

import java.util.List;
import java.util.Map;

/**
 * Created by mingjian.deng on 2018/12/13.
 */
public interface StorageTrash {
    JsonLabelInventory createTrash(TrashType type, StorageTrashSpec spec);

    Map<String, StorageTrashSpec> getTrashList(String storageUuid);
    Map<String, StorageTrashSpec> getTrashList(String storageUuid, List<TrashType> types);
    StorageTrashSpec getTrash(String storageUuid, Long trashId);

    boolean makeSureInstallPathNotUsed(StorageTrashSpec spec);
    Long getTrashId(String storageUuid, String installPath);

    void removeFromDb(String trashKey, String storageUuid);  // only remove db, not storage data
    void removeFromDb(Long trashId);
}
