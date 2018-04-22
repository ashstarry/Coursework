#ifndef __MEM_MANAGER_H__
#define __MEM_MANAGER_H__

// IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT

//

// DO NOT CHANGE THIS HEADER FILE

//

// IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT

namespace MemoryManager

{
    
    void memView(int start, int finish); // SHow the contents of memory from start to finish
    
    void initializeMemoryManager(void); // Initialize any data needed to manage the memory pool
    
    void * allocate(int); // Return a pointer inside the memory pool
    
    void deallocate(void * ); // Free up a chunk previously allocated
    
    int freeMemory(void); // Scan memory pool, return the total free space remaining
    
    int usedMemory(void); // Scan memory pool, return the total used memory that has been deallocated
    
    int inUseMemory(void); // Scan the memory pool and return the total memory being currently used
    
    void onOutOfMemory(void); // Call if no space is left for the allocation request
    
    int size(void * ); // Return the size (in bytes) of the variable that lives at this address
    
};

#endif // __MEM_MANAGER_H__
