package com.codee.plugins.api.files

public sealed interface VirtualDirectory : FSEntity {
    /**
     * @return [FSEntity] child of [VirtualDirectory] by [name].
     */
    public operator fun get(name: String): FSEntity
}